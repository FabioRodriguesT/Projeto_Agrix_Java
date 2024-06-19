package com.betrybe.agrix.service.exception;

/**
 * Class: Crop Not Found Exception.
 */
public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
