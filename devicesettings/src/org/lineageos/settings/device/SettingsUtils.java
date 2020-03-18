/*
 * Copyright (c) 2018 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.device;

import android.os.Build;
import android.os.SystemProperties;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SettingsUtils {
    public static final String TAG = "SettingsUtils";

    public static final String QC_SYSTEM_PROPERTY = "persist.sys.le_fast_chrg_enable";
    public static final String SYSTEM_PROPERTY_CAMERA_FOCUS_FIX = "persist.camera.focus_fix";
    public static final String SYSTEM_PROPERTY_PS_FB_BOOST = "persist.ps.fb_boost";
    public static final String SYSTEM_PROPERTY_QFP_WUP = "persist.qfp.wup_display";
    public static final String SYSTEM_PROPERTY_HW_0D_DISABLE = "persist.hw.0d_disable";
    public static final String SYSTEM_PROPERTY_CORE_CTL = "persist.baikal.core_ctl";
    public static final String SYSTEM_PROPERTY_INPUT_BOOST = "persist.baikal.input_boost";
    public static final String SYSTEM_PROPERTY_HP_DETECT = "persist.fx.hp_detect";


    public static final String PREFERENCES = "SettingsUtilsPreferences";

    public static void writeCameraFocusFixProp(boolean enabled) {
        SystemProperties.set(SYSTEM_PROPERTY_CAMERA_FOCUS_FIX, enabled ? "1" : "0");
    }

    public static void writeQuickChargeProp(boolean enabled) {
        SystemProperties.set(QC_SYSTEM_PROPERTY, enabled ? "1" : "0");
    }

    public static void writeFbBoostProp(boolean enabled) {
        SystemProperties.set(SYSTEM_PROPERTY_PS_FB_BOOST, enabled ? "1" : "0");
    }

    public static void writeQfpWupProp(boolean enabled) {
        SystemProperties.set(SYSTEM_PROPERTY_QFP_WUP, enabled ? "1" : "0");
    }

    public static void writeHw0DProp(boolean enabled) {
        SystemProperties.set(SYSTEM_PROPERTY_HW_0D_DISABLE, enabled ? "1" : "0");
    }

    public static void writeCoreCtlProp(boolean enabled) {
        SystemProperties.set(SYSTEM_PROPERTY_CORE_CTL, enabled ? "1" : "0");
    }

    public static void writeHpDetectProp(boolean enabled) {
        SystemProperties.set(SYSTEM_PROPERTY_HP_DETECT, enabled ? "1" : "0");
    }

    public static void writeInputBoostProp(boolean enabled) {
        SystemProperties.set(SYSTEM_PROPERTY_INPUT_BOOST, enabled ? "1" : "0");
    }

    public static boolean supportsCameraFocusFix() {
        //File focusFixPath = new File(CAMERA_FOCUS_FIX_SYSFS);
        //return focusFixPath.exists();
	return true;
    }

    public static boolean supportsQuickChargeSwitch() {
        //File QCPath = new File(QUICK_CHARGE_SYSFS);
        //return QCPath.exists();
	return true;
    }

    public static boolean getCameraFocusFixEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_CAMERA_FOCUS_FIX, false);
    }

    public static boolean getQuickChargeEnabled() {
        return SystemProperties.getBoolean(QC_SYSTEM_PROPERTY, false);
    }

    public static boolean getFbBoostEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_PS_FB_BOOST, false);
    }

    public static boolean getQfpWupEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_QFP_WUP, false);
    }

    public static boolean getHw0DEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_HW_0D_DISABLE, false);
    }

    public static boolean getCoreCtlEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_CORE_CTL, false);

    }

    public static boolean getHpDetectEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_HP_DETECT, false);
    }

    public static boolean getInputBoostEnabled() {
        return SystemProperties.getBoolean(SYSTEM_PROPERTY_INPUT_BOOST, false);
    }

    public static void registerPreferenceChangeListener(Context context,
            SharedPreferences.OnSharedPreferenceChangeListener preferenceListener) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
        settings.registerOnSharedPreferenceChangeListener(preferenceListener);
    }

    public static void unregisterPreferenceChangeListener(Context context,
            SharedPreferences.OnSharedPreferenceChangeListener preferenceListener) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCES, 0);
        settings.unregisterOnSharedPreferenceChangeListener(preferenceListener);
    }

}
