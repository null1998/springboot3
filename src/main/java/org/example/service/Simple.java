package org.example.service;

/**
 * @author huang
 */
public class Simple extends NonSealedChild{
    public static void main(String[] args) {
        NonSealedChild nonSealedChild = new NonSealedChild();
        nonSealedChild.sealed();
        nonSealedChild.nonSealed();
        Simple simple = new Simple();
        simple.sealed();
        simple.nonSealed();
    }
}
