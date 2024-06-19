package com.betrybe.agrix.service.exception;

/**
 * Class: Farm Not Found Exception.
 */
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
