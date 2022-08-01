/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public class Radio implements Volume {
  // INSTANCE VARIABLES
  private int volume;
  // for muting behavior
  private int oldVolume;
  private boolean isMuted;

  // CONSTRUCTORS
  public Radio() {
  }

  public Radio(int volume) {
    setVolume(volume);
  }
  
  // ACCESSOR METHODS
  @Override  // interface Volume
  public void setVolume(int volume) {
    this.volume = volume;
  }

  @Override  // interface Volume
  public int getVolume() {
    return volume;
  }

  @Override  // interface Volume
  public boolean isMuted() {
    return isMuted;
  }

  @Override
  public void setMuted(boolean muted) {
    isMuted = muted;
  }

  @Override
  public int getOldVolume() {
    return oldVolume;
  }

  @Override
  public void setOldVolume(int oldVolume) {
    this.oldVolume = oldVolume;
  }

  @Override
  public String toString() {
    return "Radio: volume=" + (!isMuted() ? String.valueOf(volume) : "<muted>");
  }
}