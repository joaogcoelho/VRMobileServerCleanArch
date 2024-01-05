package br.com.vrsoft.vrmobile.infrastructure.controllers.dtos;

public record DefaultResponse<T>(String mensagem, T data) {
}
