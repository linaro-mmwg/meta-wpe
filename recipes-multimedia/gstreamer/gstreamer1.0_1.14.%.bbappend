FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://0001-typefind-min-1k.patch \
    file://0002-Small-robustness-fixes-1.14.patch \
    file://0001-protection-Add-a-new-definition-for-unspecified-syst.patch \
    file://0001-protection-Fix-the-string-to-define-unspecified-syst.patch \
"
