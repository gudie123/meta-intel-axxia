FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/patches/${KV}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${CHIPSET}/${LINUX_KERNEL_TYPE}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${RUNTARGET}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

inherit axxia-kernel

KV = "4.9"
LINUX_VERSION = "4.9.78"
LINUX_KERNEL_TYPE = "standard"
PV = "${LINUX_VERSION}+git${SRCPV}"

KBRANCH_axxiapowerpc = "standard/axxia-dev/base"
SRCREV_machine_axxiapowerpc = "2f7873ff3f4662964ab91caaa245511e25f5a426"
KBRANCH_axxiaarm = "standard/axxia-dev/base"
SRCREV_machine_axxiaarm = "2f7873ff3f4662964ab91caaa245511e25f5a426"
KBRANCH_axxiaarm64 = "standard/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "2f7873ff3f4662964ab91caaa245511e25f5a426"
KBRANCH_axxiax86-64 = "standard/base"
SRCREV_machine_axxiax86-64 = "f7a6d45fff853173bfbf61706aeffcd1d1e99467"

KMETA = ""

# "simics" for simulation system or "frio" for FPGA emulation system
RUNTARGET ?= "simics"

SIMICS_PATCHES = " \
file://SIMICS-0001-intel_th-pci-Add-Cedar-Fork-PCH-support.patch \
file://SIMICS-0002-spi-nor-Add-support-for-Intel-SPI-serial-flash-contr.patch \
file://SIMICS-0003-pinctrl-intel-set-default-handler-to-be-handle_bad_i.patch \
file://SIMICS-0004-pinctrl-baytrail-Do-not-add-all-GPIOs-to-IRQ-domain.patch \
file://SIMICS-0005-pinctrl-intel-Convert-to-use-devm_gpiochip_add_data.patch \
file://SIMICS-0006-pinctrl-intel-Add-support-for-hardware-debouncer.patch \
file://SIMICS-0007-pinctrl-intel-Add-support-for-1k-additional-pull-dow.patch \
file://SIMICS-0008-pinctrl-intel-unlock-on-error-in-intel_config_set_pu.patch \
file://SIMICS-0009-pinctrl-intel-Add-support-for-variable-size-pad-grou.patch \
file://SIMICS-0010-pinctrl-intel-Make-it-possible-to-specify-mode-per-p.patch \
file://SIMICS-0011-mtd-spi-nor-intel-spi-Add-support-for-Intel-Denverto.patch \
file://SIMICS-0012-pinctrl-intel-Add-Intel-Denverton-pin-controller-sup.patch \
file://SIMICS-0013-i2c-i801-Add-support-for-Intel-Cedar-Fork.patch \
file://SIMICS-0014-pinctrl-intel-Make-offset-to-interrupt-status-regist.patch \
file://SIMICS-0015-pinctrl-intel-Add-Intel-Cedar-Fork-PCH-pin-controlle.patch \
file://SIMICS-0016-mtd-spi-nor-intel-spi-Add-support-for-Intel-Cedar-Fo.patch \
"

KREPO_KERNEL = "git://git@github.com/axxia/axxia_yocto_linux_4.9_private.git;protocol=ssh"
SRC_URI = "${KREPO_KERNEL};name=machine;branch=${KBRANCH} \
           ${@base_conditional('RUNTARGET', 'simics', '${SIMICS_PATCHES}', '', d)} \
           file://fit \
           file://defconfig"

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