FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/patches/${KV}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${RUNTARGET}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

inherit axxia-kernel

KV = "4.9"
LINUX_VERSION = "4.9.61"
LINUX_KERNEL_TYPE = "standard"
PV = "${LINUX_VERSION}+git${SRCPV}"

# "simics" for simulation system or "frio" for FPGA emulation system
RUNTARGET ?= "simics"

SIMICS_PATCHES = " \
file://0001-intel_th-pci-Add-Cedar-Fork-PCH-support.patch \
file://0002-drivers-pinctrl-Backport-Cedar-Fork-GPIO.patch \
"

FRIO_PATCHES = " \
file://0001-PCI-ASPM-Don-t-retrain-link.patch \
file://0002-pci-driver-HACK-reassign-Altera-FPGAs-if-they-have-n.patch \
file://0003-pci-driver-HACK-hardcode-size-of-bridge-window-to-NC.patch \
file://0004-pci-driver-HACK-don-t-allocate-additional-bridge-win.patch \
file://0005-pci-driver-HACK-merge-for-Altera.patch \
"

KBRANCH = "standard/axxia-dev/base"
KREPO_KERNEL = "git://git@github.com/axxia/axxia_yocto_linux_4.9_private.git;protocol=ssh"
SRC_URI = "${KREPO_KERNEL};name=machine;branch=${KBRANCH} \
           ${@base_conditional('RUNTARGET', 'frio', '${FRIO_PATCHES}', '', d)} \
           ${@base_conditional('RUNTARGET', 'simics', '${SIMICS_PATCHES}', '', d)} \
           file://fit \
           file://defconfig"
SRCREV_machine ="${AUTOREV}"
KMETA = ""

require dt/dt-${KARCH}.inc

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiaarm64$|^axxiax86-64$"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""