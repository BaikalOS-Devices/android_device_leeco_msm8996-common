/*
 * Copyright (C) 2018 The LineageOS Project
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

import android.os.Bundle;
import android.os.SystemProperties;
import android.provider.Settings;
import android.content.Intent;
import androidx.preference.PreferenceFragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import android.util.Log;

public class LeecoPreferenceFragment extends PreferenceFragment {

    private static final String KEY_CAMERA_FOCUS_FIX_ENABLE = "camera_focus_enable";
    private static final String KEY_QUICK_CHARGE_ENABLE = "quick_charge_enable";

    public static final String QC_SYSTEM_PROPERTY = "persist.sys.le_fast_chrg_enable";
    public static final String SYSTEM_PROPERTY_CAMERA_FOCUS_FIX = "persist.camera.focus_fix";
    public static final String SYSTEM_PROPERTY_PS_FB_BOOST = "persist.ps.fb_boost";
    public static final String SYSTEM_PROPERTY_QFP_WUP = "persist.qfp.wup_display";
    public static final String SYSTEM_PROPERTY_HW_0D_DISABLE = "persist.hw.0d_disable";
    public static final String SYSTEM_PROPERTY_CORE_CTL = "persist.baikal.core_ctl";
    public static final String SYSTEM_PROPERTY_HP_DETECT = "persist.fx.hp_detect";
    public static final String SYSTEM_PROPERTY_INPUT_BOOST = "persist.baikal.input_boost";


    private SwitchPreference mCameraFocusFixEnable;
    private SwitchPreference mQuickChargeEnable;
    private SwitchPreference mFbBoostEnable;
    //private SwitchPreference mQfpWupEnable;
    private SwitchPreference mHw0DEnable;
    private SwitchPreference mCoreCtl;
    //private SwitchPreference mHpDetect;
    private SwitchPreference mInputBoost;

    private Preference mKcalPref;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.leeco_settings_panel);
        final PreferenceScreen prefSet = getPreferenceScreen();


        mKcalPref = findPreference("kcal");
        if(  mKcalPref != null ) {
            mKcalPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(getContext(), DisplayCalibration.class);
                    startActivity(intent);
                    return true;
                }
            });
        }

        mCameraFocusFixEnable = (SwitchPreference) findPreference(SYSTEM_PROPERTY_CAMERA_FOCUS_FIX);
        mQuickChargeEnable = (SwitchPreference) findPreference(QC_SYSTEM_PROPERTY);
        mFbBoostEnable = (SwitchPreference) findPreference(SYSTEM_PROPERTY_PS_FB_BOOST);
        //mQfpWupEnable = (SwitchPreference) findPreference(SYSTEM_PROPERTY_QFP_WUP);
        mHw0DEnable = (SwitchPreference) findPreference(SYSTEM_PROPERTY_HW_0D_DISABLE);
    	mCoreCtl = (SwitchPreference) findPreference(SYSTEM_PROPERTY_CORE_CTL);
    	//mHpDetect = (SwitchPreference) findPreference(SYSTEM_PROPERTY_HP_DETECT);
    	mInputBoost = (SwitchPreference) findPreference(SYSTEM_PROPERTY_INPUT_BOOST);

        if (!isZl1()) {
            mCameraFocusFixEnable.setChecked(SettingsUtils.getCameraFocusFixEnabled());
            mCameraFocusFixEnable.setOnPreferenceChangeListener(PrefListener);
	        //mQfpWupEnable.setChecked(SettingsUtils.getQfpWupEnabled());
            //mQfpWupEnable.setOnPreferenceChangeListener(PrefListener);
        } else {
            prefSet.removePreference(mCameraFocusFixEnable);
            //prefSet.removePreference(mQfpWupEnable);
        }

    	mQuickChargeEnable.setChecked(SettingsUtils.getQuickChargeEnabled());
    	mQuickChargeEnable.setOnPreferenceChangeListener(PrefListener);

    	mFbBoostEnable.setChecked(SettingsUtils.getFbBoostEnabled());
    	mFbBoostEnable.setOnPreferenceChangeListener(PrefListener);

    	mHw0DEnable.setChecked(SettingsUtils.getHw0DEnabled());
    	mHw0DEnable.setOnPreferenceChangeListener(PrefListener);

    	mCoreCtl.setChecked(SettingsUtils.getCoreCtlEnabled());
    	mCoreCtl.setOnPreferenceChangeListener(PrefListener);

    	//mHpDetect.setChecked(SettingsUtils.getHpDetectEnabled());
    	//mHpDetect.setOnPreferenceChangeListener(PrefListener);

    	mInputBoost.setChecked(SettingsUtils.getInputBoostEnabled());
    	mInputBoost.setOnPreferenceChangeListener(PrefListener);

    }

    @Override
    public void onResume() {
        super.onResume();
        getListView().setPadding(0, 0, 0, 0);
    }

    private boolean isZl1() {
        if(SystemProperties.get("ro.product.vendor.device").equals("zl1")) {
            return true;
        } else {
            return false;
        }
    }

    private Preference.OnPreferenceChangeListener PrefListener =
        new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            final String key = preference.getKey();

            if (SYSTEM_PROPERTY_CAMERA_FOCUS_FIX.equals(key)) {
                boolean enabled = (boolean) value;
                SettingsUtils.writeCameraFocusFixProp(enabled);
            } else if (QC_SYSTEM_PROPERTY.equals(key)) {
                boolean enabled = (boolean) value;
                SettingsUtils.writeQuickChargeProp(enabled);
            } else if (SYSTEM_PROPERTY_PS_FB_BOOST.equals(key)) {
                boolean enabled = (boolean) value;
                SettingsUtils.writeFbBoostProp(enabled);
            } else if (SYSTEM_PROPERTY_QFP_WUP.equals(key)) {
                boolean enabled = (boolean) value;
                SettingsUtils.writeQfpWupProp(enabled);
            } else if (SYSTEM_PROPERTY_HW_0D_DISABLE.equals(key)) {
                boolean enabled = (boolean) value;
                SettingsUtils.writeHw0DProp(enabled);
            } else if (SYSTEM_PROPERTY_CORE_CTL.equals(key)) {
                boolean enabled = (boolean) value;
                SettingsUtils.writeCoreCtlProp(enabled);
            } else if (SYSTEM_PROPERTY_HP_DETECT.equals(key)) {
                boolean enabled = (boolean) value;
                //SettingsUtils.writeHpDetectProp(enabled);
            } else if (SYSTEM_PROPERTY_INPUT_BOOST.equals(key)) {
                boolean enabled = (boolean) value;
                SettingsUtils.writeInputBoostProp(enabled);
	    }

            return true;
        }
    };
}
