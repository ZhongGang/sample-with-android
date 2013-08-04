package com.example.core;

import android.hardware.Camera;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-4
 * Time: 下午10:36
 */
public class FlashLightController {
    private boolean on = false;

    public FlashLightController(boolean on) {
        this.on = on;
    }

    public void controller() {
        Camera camera = Camera.open();
        if (camera == null) {
            return;
        }

        if (on) {
            turnOn(camera);
        } else {
            turnOff(camera);
        }
    }

    public void turnOn(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
    }

    public void turnOff(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.release();
    }
}
