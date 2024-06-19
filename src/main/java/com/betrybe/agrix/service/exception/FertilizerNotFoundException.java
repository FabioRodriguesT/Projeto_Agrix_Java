package com.betrybe.agrix.service.exception;

/**
 * Class: Fertilizer Not Found Exception.
 */
public class FertilizerNotFoundException extends NotFoundException {
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}