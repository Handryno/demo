package com.example.demo.util;

public class Constants {

    public enum RESPONSE {
        APPROVED("00", "Approved"),
        AUTHENTICATION_PROBLEM("X1", "Authentication Problem"),
        HTTP_BODY_NOT_FOUND("X3", "HTTP Body not Found"),
        HTTP_NOT_FOUND("X4", "There is No Resource Path"),
        HTTP_INTERNAL_ERROR("X5", "Service Internal Error"),
        SERVICE_DOWN("X6", "Service Down"),
        INVALID_TRANSACTION("12", "Transaksi tidak sesuai"),
        INVALID_AMOUNT("13", "Jumlah Transaksi tidak sesuai"),
        ACCOUNT_NOT_FOUND("14", "Data tidak ditemukan"),
        DATA_EXITS("15", "Data sudah ada"),
        DATA_BLACKLIST("40", "Data Blacklist"),
        WRONG_FORMAT_DATA("30", "Format Data Salah"),
        CA_NOT_REGISTERED_OR_INVALID_CODE("31", "Client tidak terdaftar/salah password"),
        TRANSACTION_TIMEOUT("68", "Transaction Timeout"),
        TAGIHAN_SUDAH_TERBAYAR("88","Tagihan Sudah Terbayar"),
        SYSTEM_MAINTENANCE("96", "System Maintenance"),
        CUT_OFF_TOME("90","Cut Off Time"),
        GENERAL_ERROR("98", "General Error"),
        ;

        private String code, description;

        RESPONSE(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return this.code;
        }

        public String getDescription() {
            return this.description;
        }
    }
}
