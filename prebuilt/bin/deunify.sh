#!/sbin/sh
#
# deunify
#

# DEVINFO
DEVINFO=$(cat /dev/block/sde21)

echo "DEVINFO: ${DEVINFO}"

case "$DEVINFO" in
  le_zl0*)
    # Move firmware
    mv -f /system/vendor/firmware/zl0/* /system/vendor/firmware/

    # Remove NFC perms
    rm -f /system/vendor/etc/permissions/android.hardware.nfc*
    rm -f /system/vendor/etc/permissions/com.android.nfc*

    # Remove NFC services
    rm -f /system/vendor/etc/init/android.hardware.nfc*
    rm -f /system/vendor/etc/init/vendor.nxp.hardware.nfc*

    # Remove SmartcardService
    rm -f /system/etc/permissions/org.simalliance.openmobileapi.xml
    rm -f /system/framework/org.simalliance.openmobileapi.jar
    rm -rf /system/vendor/app/SmartcardService
    ;;
  le_zl1*)
    # Remove qti-telephony-common.jar
    rm -f /system/framework/qti-telephony-common.jar
    ;;
  *)
    echo "Nothing to do!"
    ;;
esac

exit 0
