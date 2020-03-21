#
# Vendor properties for msm8996-common
#

# Audio
PRODUCT_PROPERTY_OVERRIDES += \
    af.fast_track_multiplier=2 \
    audio.heap.size.multiplier=10 \
    audio.offload.min.duration.secs=15 \
    audio.offload.video=true \
    persist.audio.ssr.3mic=false \
    persist.vendor.audio.fluence.audiorec=false \
    persist.vendor.audio.fluence.speaker=true \
    persist.vendor.audio.fluence.voicecall=true \
    persist.vendor.audio.fluence.voicerec=false \
    ro.af.client_heap_size_kbyte=7168 \
    ro.config.media_vol_steps=25 \
    ro.config.vc_call_vol_steps=7 \
    ro.vendor.audio.sdk.fluencetype=fluence \
    ro.vendor.audio.sdk.ssr=false \
    vendor.audio.dolby.ds2.enabled=true \
    vendor.audio.dolby.ds2.hardbypass=true \
    vendor.audio.flac.sw.decoder.24bit=false \
    vendor.audio_hal.period_size=192 \
    vendor.audio.hw.aac.encoder=true \
    ro.audio.offload_wakelock=false \
    vendor.audio.offload.buffer.size.kb=512 \
    vendor.audio.offload.gapless.enabled=true \
    vendor.audio.offload.multiaac.enable=true \
    vendor.audio.offload.multiple.enabled=true \
    vendor.audio.offload.passthrough=false \
    vendor.audio.offload.pcm.16bit.enable=true \
    vendor.audio.offload.pcm.24bit.enable=true \
    vendor.audio.offload.pstimeout.secs=1 \
    vendor.audio.offload.track.enable=true \
    vendor.audio.parser.ip.buffer.size=262144 \
    vendor.audio.safx.pbe.enabled=true \
    vendor.audio.tunnel.encode=false \
    vendor.audio.use.sw.alac.decoder=true \
    vendor.audio.use.sw.ape.decoder=true \
    vendor.voice.path.for.pcm.voip=true

# Audio (AAC 5.1 output)
PRODUCT_PROPERTY_OVERRIDES += \
    media.aac_51_output_enabled=true

# Bluetooth
PRODUCT_PROPERTY_OVERRIDES += \
    bt.max.hfpclient.connections=2 \
    ro.bluetooth.wipower=true \
    ro.bluetooth.emb_wp_mode=true \
    vendor.qcom.bluetooth.soc=rome

# Camera
PRODUCT_PROPERTY_OVERRIDES += \
    persist.camera.HAL3.enabled=1 \
    persist.camera.imglib.fddsp=1 \
    persist.camera.llc=1 \
    persist.camera.llnoise=1

# CNE
PRODUCT_PROPERTY_OVERRIDES += \
    persist.vendor.cne.feature=1

# Data modules
PRODUCT_PROPERTY_OVERRIDES += \
    persist.data.iwlan.enable=true \
    persist.data.mode=concurrent \
    persist.data.netmgrd.qos.enable=true \
    ro.vendor.use_data_netmgrd=true

# Devinfo for init
PRODUCT_PROPERTY_OVERRIDES += \
    ro.leeco.devinfo=NULL

# Display (Qualcomm Assertive Display)
PRODUCT_PROPERTY_OVERRIDES += \
    ro.qcom.ad=1 \
    ro.qcom.ad.sensortype=3 \
    ro.vendor.display.cabl=2

# DPM
PRODUCT_PROPERTY_OVERRIDES += \
    persist.vendor.dpm.feature=5

# DRM
PRODUCT_PROPERTY_OVERRIDES += \
    drm.service.enabled=true

# Fastcharge
PRODUCT_PROPERTY_OVERRIDES += \
    persist.sys.le_fast_chrg_enable=1

# FRP
PRODUCT_PROPERTY_OVERRIDES += \
    ro.frp.pst=/dev/block/bootdevice/by-name/frp

# Graphics
PRODUCT_PROPERTY_OVERRIDES += \
    debug.egl.hw=1 \
    debug.sf.enable_hwc_vds=1 \
    debug.sf.hw=1 \
    dev.pm.dyn_samplingrate=1 \
    persist.debug.wfd.enable=1 \
    persist.demo.hdmirotationlock=false \
    persist.hwc.enable_vds=1 \
    persist.sys.wfd.nohdcp=1 \
    persist.sys.wfd.virtual=0 \
    ro.persist.qcapb=1 \
    vendor.display.disable_rotator_split=1 \
    vendor.display.disable_skip_validate=1 \
    vendor.display.enable_default_color_mode=1 \
    vendor.display.perf_hint_window=50 \
    vendor.video.disable.ubwc=1 \
    debug.gralloc.enable_fb_ubwc=1 \
    vendor.gralloc.disable_wb_ubwc=1 


# Graphics (OpenGLES)
PRODUCT_PROPERTY_OVERRIDES += \
   ro.opengles.version=196610

# IMS / VoLTE
PRODUCT_PROPERTY_OVERRIDES += \
   persist.dbg.volte_avail_ovr=1 \
   persist.dbg.vt_avail_ovr=1 \
   persist.dbg.wfc_avail_ovr=1 \
   persist.radio.VT_CAM_INTERFACE=2 \
   persist.radio.VT_ENABLE=1 \
   persist.radio.VT_HYBRID_ENABLE=1 \
   persist.radio.ROTATION_ENABLE=1 \
   persist.vendor.qti.telephony.vt_cam_interface=2

# Media
PRODUCT_PROPERTY_OVERRIDES += \
   vidc.debug.perf.mode=2 \
   vidc.enc.dcvs.extra-buff-count=2

# Perf
PRODUCT_PROPERTY_OVERRIDES += \
   ro.vendor.extension_library=libqti-perfd-client.so \
   ro.vendor.qti.sys.fw.bg_apps_limit=200

# RIL
PRODUCT_PROPERTY_OVERRIDES += \
    DEVICE_PROVISIONED=1 \
    rild.libpath=/vendor/lib64/libril-qc-qmi-1.so \
    ril.subscription.types=NV,RUIM \
    ro.telephony.call_ring.multiple=false \
    persist.data.qmi.adb_logmask=0 \
    persist.net.doxlat=true \
    persist.radio.apm_sim_not_pwdn=1 \
    persist.radio.csvt.enabled=false \
    persist.radio.REVERSE_QMI=0 \
    persist.radio.ROTATION_ENABLE=1 \
    persist.rcs.supported=1 \
    persist.vendor.radio.cs_srv_type=1 \
    persist.vendor.radio.custom_ecc=1 \
    persist.vendor.radio.data_ltd_sys_ind=1 \
    persist.vendor.radio.facnotsup_as_nonw=1 \
    persist.vendor.radio.force_on_dc=true \
    persist.vendor.radio.ignore_dom_time=5 \
    persist.vendor.radio.rat_on=combine \
    persist.vendor.radio.redir_party_num=1 \
    persist.vendor.radio.mt_sms_ack=20 \
    persist.vendor.radio.sib16_support=1 \
    ro.telephony.use_old_mnc_mcc_format=true \
    telephony.lteOnCdmaDevice=1 \
    persist.sys.fflag.override.settings_network_and_internet_v2=true

# Surfaceflinger
PRODUCT_PROPERTY_OVERRIDES += \
    debug.sf.early_phase_offset_ns=1500000 \
    debug.sf.early_app_phase_offset_ns=1500000 \
    debug.sf.early_gl_phase_offset_ns=3000000 \
    debug.sf.early_gl_app_phase_offset_ns=15000000 \
    debug.sf.use_smart_90_for_video=1

# System props for the MM modules
PRODUCT_PROPERTY_OVERRIDES += \
    audio.deep_buffer.media=true \
    media.stagefright.enable-player=true \
    media.stagefright.enable-http=true \
    media.stagefright.enable-aac=true \
    media.stagefright.enable-qcp=true \
    media.stagefright.enable-fma2dp=true \
    media.stagefright.enable-scan=true \
    mmp.enable.3g2=true \
    mm.enable.smoothstreaming=true \
    mm.enable.qcom_parser=4194303 \
    persist.mm.enable.prefetch=true

# Timeservice
PRODUCT_PROPERTY_OVERRIDES += \
    persist.timed.enable=true

# Wifi
PRODUCT_PROPERTY_OVERRIDES += \
    wifi.interface=wlan0

# FinigerprintService
PRODUCT_PROPERTY_OVERRIDES += \
    ro.fingerprint.cleanup.unused=false

# BaikalService 
PRODUCT_PROPERTY_OVERRIDES += \
    baikal.eng.perf=1 \
    baikal.eng.therm=1 \
    baikal.eng.core_ctl=1 \
    sys.baikal.min_cpus=2

# Baikal Maintainer
PRODUCT_PROPERTY_OVERRIDES += \
    ro.baikalos.maintainer=svasiliev22
