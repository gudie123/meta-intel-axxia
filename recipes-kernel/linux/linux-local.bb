########################## linux-local.bb ############################
# Simple recipe to build kernel from local repository.               #
# Set linux-local as PREFERRED_PROVIDER for virtual/kernel component #
#     PREFERRED_PROVIDER_virtual/kernel = "linux-local"              #
# To build only the kernel run:                                      #
#      $ bitbake linux-local                                         #
# All changes should be committed in the local kernel clone.         #
# Full defconfig should be copied in this directory (besides recipe) #
# Adjust the following lines with the kernel path and branch.        #
######################################################################

LOCAL_KERNEL_PATH ?= "path-to-local-kernel-repository"
LOCAL_KERNEL_BRANCH ?= "standard/base"

require recipes-kernel/linux/linux-yocto.inc

PV = "dev-version"

SRCREV_machine_axxiax86-64 = "${AUTOREV}"

SRC_URI_axxiax86-64 = " \
	git://${LOCAL_KERNEL_PATH};name=machine;branch=${LOCAL_KERNEL_BRANCH} \
	file://${THISDIR}/defconfig \
	"

COMPATIBLE_MACHINE_axxiax86-64 = "${MACHINE}"
KERNEL_VERSION_SANITY_SKIP = "1"