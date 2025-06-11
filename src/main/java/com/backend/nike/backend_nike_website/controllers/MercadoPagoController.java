package com.backend.nike.backend_nike_website.controllers;

import com.backend.nike.backend_nike_website.entities.OrdenCompra;
import com.backend.nike.backend_nike_website.entities.Producto;
import com.mercadopago.MercadoPagoConfig;
import com.backend.nike.backend_nike_website.services.OrdenCompraService;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class MercadoPagoController {
    private final OrdenCompraService ordenCompraService;

    @Value("${mercadopago.access-token}")
    private String mercadoPagoAccessToken;

    @PostMapping("/mp")
    public ResponseEntity<Map<String, Object>> mp( @RequestBody Map<String, List<Long>> body) throws Exception {
        try {
        List<Long> ids = body.get("id");
        MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
        List<PreferenceItemRequest> items = new ArrayList<>();

        OrdenCompra ordenCompra = ordenCompraService.generarOrdenCompra(ids);


        for (Producto detalle : ordenCompra.getProductos()) {
            Double precioFinal = detalle.getPrecio();
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .id(detalle.getId().toString())
                    .title(detalle.getNombre())
                    .description(detalle.getDescripcion())
                    .quantity(1)
                    .currencyId("ARS")
                    .unitPrice(BigDecimal.valueOf(precioFinal))
                    .build();
            items.add(item);
        }
        PreferenceBackUrlsRequest backUrls =
                PreferenceBackUrlsRequest.builder()
                        .success("https://localhost:5173/paymentSuccess")
                        .pending("https://localhost:5173/")
                        .failure("https://localhost:5173/paymentFailure")
                        .build();

        List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
        excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("ticket").build());

        /*
         *Otros ejemplos de id que podrías excluir:
         * "credit_card": tarjetas de crédito
         * "debit_card": tarjetas de débito
         * "ticket": pagos en efectivo como Rapipago o Pago Fácil
         * "atm": pagos a través de cajero automático
         */

        PreferencePaymentMethodsRequest paymentMethods = PreferencePaymentMethodsRequest.builder()
                .excludedPaymentTypes(excludedPaymentTypes)
                .installments(1)
                .build();
        //el campo installments(1) se refiere a la cantidad máxima de cuotas permitidas para realizar el pago

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .paymentMethods(paymentMethods)
                .autoReturn("approved")
                .build();

        PreferenceClient client = new PreferenceClient();
        Preference preference = client.create(preferenceRequest);


        String prefId = preference.getId();
            ordenCompra.setPreferenceId(prefId);
            ordenCompraService.save(ordenCompra);  // Guardar la orden actualizada

        Map<String, Object> response = new HashMap<>();
        response.put("preferenceId", prefId);
        response.put("urlMP", preference.getInitPoint());
        response.put("orden", ordenCompra);
        return ResponseEntity.ok(response);

    } catch (Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", e.getMessage()));
    }

    }
    @PatchMapping("/update-status/{ordenId}")
    public ResponseEntity<?> actualizarEstadoOrden(
            @PathVariable Integer ordenId,
            @RequestParam String nuevoEstado) {

        try {
            OrdenCompra orden = ordenCompraService.findById(ordenId);
            if (orden == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Orden no encontrada");
            }

            orden.setEstado(nuevoEstado);
            ordenCompraService.save(orden);

            return ResponseEntity.ok("Estado actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error actualizando el estado: " + e.getMessage());
        }
    }

    @PatchMapping("/update-status/preference/{preferenceId}")
    public ResponseEntity<?> actualizarEstadoPorPreferenceId(
            @PathVariable String preferenceId,
            @RequestParam String nuevoEstado) {

        try {
            Optional<OrdenCompra> ordenOptional = ordenCompraService.findByPreferenceId(preferenceId);

            if (ordenOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Orden no encontrada con preferenceId: " + preferenceId);
            }

            OrdenCompra orden = ordenOptional.get();
            orden.setEstado(nuevoEstado);
            ordenCompraService.save(orden);

            return ResponseEntity.ok("Estado actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error actualizando el estado: " + e.getMessage());
        }
    }


}
