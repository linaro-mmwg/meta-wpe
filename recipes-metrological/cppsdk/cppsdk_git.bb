SUMMARY = "Metrological's CPP SDK abstraction layer"
HOMEPAGE = "http://www.metrological.com/"
SECTION = "metrological"
LICENSE = "CLOSED"

DEPENDS = "zlib"

PV = "1.0+gitr${SRCPV}"

SRC_URI = "git://git@github.com/Metrological/cppsdk.git;protocol=ssh"

SRCREV = "44184bfc92f9381b75b86594e4dc9b3130d911aa"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

CPPSDK_PLATFORM ?= "platform-pc"
CPPSDK_PLATFORM_7401 = "platform-intelce"
CPPSDK_PLATFORM_dawn = "platform-dawn"
CPPSDK_PLATFORM_eos = "platform-eos"
CPPSDK_PLATFORM_rpi = "platform-rpi"

PACKAGECONFIG ?= "${CPPSDK_PLATFORM} cryptalgo devices generics process tracing websocket rpc"

PACKAGECONFIG[platform-dawn] = "-DCPPSDK_PLATFORM=DAWN,,"
PACKAGECONFIG[platform-eos] = "-DCPPSDK_PLATFORM=EOS,,"
PACKAGECONFIG[platform-intelce] = "-DCPPSDK_PLATFORM=INTELCE,,intelce-osal intelce-cosai"
PACKAGECONFIG[platform-pc] = "-DCPPSDK_PLATFORM=PC_UNIX,,"
PACKAGECONFIG[platform-rpi] = "-DCPPSDK_PLATFORM=RPI,,"

PACKAGECONFIG[cryptalgo] = "-DCPPSDK_CRYPTALGO=ON,-DCPPSDK_CRYPTALGO=OFF,"
PACKAGECONFIG[debug] = "-DCPPSDK_DEBUG=ON,-DCPPSDK_DEBUG=OFF,"
PACKAGECONFIG[devices] = "-DCPPSDK_DEVICES=ON,-DCPPSDK_DEVICES=OFF,"
PACKAGECONFIG[generics] = "-DCPPSDK_GENERICS=ON,-DCPPSDK_GENERICS=OFF,"
PACKAGECONFIG[tracing] = "-DCPPSDK_TRACING=ON,-DCPPSDK_TRACING=OFF,"
PACKAGECONFIG[unittests] = "-DCPPSDK_UNIT_TESTS=ON,-DCPPSDK_UNIT_TESTS=OFF,"
PACKAGECONFIG[websocket] = "-DCPPSDK_WEBSOCKET=ON,-DCPPSDK_WEBSOCKET=OFF,"
PACKAGECONFIG[rpc] = "-DCPPSDK_RPC=ON,-DCPPSDK_RPC=OFF,"
PACKAGECONFIG[process] = "-DCPPSDK_PROCESS=ON,-DCPPSDK_PROCESS=OFF,"

EXTRA_OECMAKE += " \
    -DINSTALL_HEADERS_TO_TARGET=ON \
"

TOOLCHAIN = "gcc"

