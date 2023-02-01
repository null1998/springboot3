package org.example.service;

/**
 * @author huang
 */
public sealed class SealedParent permits NonSealedChild{
    protected void sealed() {
    }
}
