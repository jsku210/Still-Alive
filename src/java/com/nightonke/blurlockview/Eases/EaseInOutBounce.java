package com.nightonke.blurlockview.Eases;

public class EaseInOutBounce extends CubicBezier {
    private float easeOutBounce(float f, float f2, float f3, float f4) {
        f /= f4;
        if (f < 0.36363637f) {
            return (f3 * ((7.5625f * f) * f)) + f2;
        }
        if (f < 0.72727275f) {
            f -= 0.54545456f;
            return (f3 * (((7.5625f * f) * f) + 0.75f)) + f2;
        } else if (((double) f) < 0.9090909090909091d) {
            f -= 0.8181818f;
            return (f3 * (((7.5625f * f) * f) + 0.9375f)) + f2;
        } else {
            f -= 0.95454544f;
            return (f3 * (((7.5625f * f) * f) + 0.984375f)) + f2;
        }
    }

    public float getOffset(float f) {
        if (f < 0.5f) {
            return (easeInBounce(f * 2.0f, 0.0f, 1.0f, 1.0f) * 0.5f) + 0.0f;
        }
        return ((easeOutBounce((f * 2.0f) - 1.0f, 0.0f, 1.0f, 1.0f) * 0.5f) + 0.5f) + 0.0f;
    }

    private float easeInBounce(float f, float f2, float f3, float f4) {
        return (f3 - easeOutBounce(f4 - f, 0.0f, f3, f4)) + f2;
    }
}
