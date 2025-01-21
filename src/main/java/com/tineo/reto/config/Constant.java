package com.tineo.reto.config;

public class Constant {

    // api version
    public static final String API_VERSION = "/api/v1";

    // global exception messages
    public static final String GLOBAL_EXCEPTION_ERROR_DETAILS = "[%s] %s";

    // tipo cambio - endpoints
    public static final String TIPO_CAMBIO = API_VERSION + "/tipo-cambio";

    // tipo cambio - messages
    public static final String TIPO_CAMBIO_FOUND = "Tipo de cambio encontrado";

    public static final String TIPO_CAMBIO_NOT_FOUND = "Tipo de cambio no encontrado -> id: ";

    // moneda - messages
    public static final String MONEDA_NOT_FOUND = "Moneda no encontrada -> id: ";
}
