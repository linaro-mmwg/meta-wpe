require wpewebkit.inc

PV = "2.22+git${SRCPV}"
PR = "r0"

SRCREV ?= "2f7b737d735c67d8229f576d54a9c907b7057d94"
SRC_URI = "git://github.com/WebPlatformForEmbedded/WPEWebKit.git;branch=wpe-2.22 \
           file://0001-Fix-build-with-musl.patch \
           file://0002-Define-MESA_EGL_NO_X11_HEADERS-when-not-using-GLX.patch \
        "

DEPENDS += "libgcrypt"
PACKAGECONFIG_append = " webcrypto"

FILES_${PN} += "${libdir}/wpe-webkit-0.1/injected-bundle/libWPEInjectedBundle.so"
FILES_${PN}-web-inspector-plugin += "${libdir}/wpe-webkit-0.1/libWPEWebInspectorResources.so"
