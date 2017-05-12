FILESEXTRAPATHS_prepend := "${THISDIR}:"

inherit axxia-kernel

KV = "4.1"
LINUX_VERSION = "4.1.39"

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiaarm64$"
INSANE_SKIP_kernel-dev = "debug-files"
PARALLEL_MAKE = ""

AXXIA_SRC ?= "linux-yocto"
SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""

require ${AXXIA_SRC}-rt_4.1.inc
