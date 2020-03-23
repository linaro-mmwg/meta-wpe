# WPE Framework common
HOMEPAGE = "https://github.com/WebPlatformForEmbedded"
SECTION = "wpe"

PV = "3.0+git${SRCPV}"

PACKAGECONFIG ??= ""
PACKAGECONFIG[debug]            = "-DCMAKE_BUILD_TYPE=Debug,-DCMAKE_BUILD_TYPE=Release,"
PACKAGECONFIG[sdp]              = "-DSECURE_DATA_PATH=ON,,"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

PACKAGECONFIG_append = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'sdp', 'sdp', '', d)} \
    "
EXTRA_OECMAKE += "-DCMAKE_SYSROOT=${STAGING_DIR_HOST}"
