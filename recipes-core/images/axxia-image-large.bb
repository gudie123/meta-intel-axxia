DESCRIPTION = "A large and complete image including all Intel Axxia \
required packages."

require recipes-core/images/core-image-minimal-dev.bb
require axxia-image.inc

IMAGE_INSTALL = " \
acl \
at \
attr \
autofs \
axxia-rc-local \
base-files \
base-passwd \
bash \
bc \
beecrypt \
bind \
bind-utils \
bison \
bluez5 \
boost \
boost-dev \
busybox \
busybox-udhcpc \
bzip2 \
coreutils \
cpio \
cracklib \
cronie \
curl \
db \
dbus \
dbus-glib \
dhcp-client \
dhcp-server \
diffutils \
dmidecode \
e2fsprogs \
e2fsprogs-badblocks \
e2fsprogs-e2fsck \
e2fsprogs-mke2fs \
e2fsprogs-resize2fs \
e2fsprogs-tune2fs \
ed \
elfutils \
ethtool \
expat \
expect \
file \
findutils \
flac \
flex \
gawk \
gdb \
gdbserver \
gettext \
glib-2.0 \
gmp \
gnutls \
grep \
groff \
gzip \
hdparm \
hostap-utils \
iasl \
icu \
inetutils \
inetutils-telnetd \
init-ifupdown \
initscripts \
iproute2 \
iptables \
iputils \
irda-utils \
kdump \
kernel-modules \
kexec \
kexec-tools \
kmod \
ldd \
less \
libaio \
libasan \
libcap \
libcheck \
libdaemon \
libevent \
libffi \
libgcc \
libgcrypt \
libgpg-error \
libice \
libkmod \
libnfsidmap \
libnl \
libnl-genl \
libnl-nf \
libnl-route \
libnss-mdns \
libogg \
libpam \
libpcap \
libpcap-dev \
libpcre \
libpython2 \
libpython3 \
libsamplerate0 \
libsm \
libsndfile1 \
libtasn1 \
libtirpc \
libtool \
libubsan \
libudev \
libunwind \
libusb-compat \
libusb1 \
libxau \
libxcb \
libxdmcp \
lighttpd \
logrotate \
lrzsz \
ltp \
lvm2 \
lzo \
man \
man-pages \
mdadm \
mktemp \
modutils-initscripts \
msmtp \
mtd-utils \
ncurses \
net-tools \
netkit-tftp-client \
netbase \
netcat \
nfs-utils \
nfs-utils-client \
numactl \
openssh \
openssh-sftp \
openssh-sftp-server \
openssl \
opkg \
opkg-arch-config \
ossp-uuid \
packagegroup-core-boot \
packagegroup-core-buildessential \
parted \
pciutils \
perl \
perl-module-bigint \
pkgconfig \
pmtools \
popt \
ppp \
procps \
psmisc \
python-cffi \
python-core \
python-dev \
python-distutils \
python-modules \
python-netserver \
python-nose \
python3-cffi \
python3-core \
python3-dev \
python3-distutils \
python3-modules \
python3-netserver \
python3-nose \
python3-pexpect \
python3-pyexpect \
python3-pyyaml \
python3-pynetlinux \
python3-robotframework \
python3-scapy \
quota \
readline \
rpcbind \
rpm \
run-postinsts \
sed \
setserial \
shadow \
shadow-securetty \
sqlite3 \
stat \
strace \
strongswan \
sudo \
swig \
sysfsutils \
sysklogd \
tar \
tcl \
tcp-wrappers \
tcpdump \
telnetd \
time \
tk \
tmux \
tzdata \
udev \
udev-extraconf \
unzip \
update-rc.d \
usbutils \
util-linux \
util-linux-libblkid \
util-linux-libuuid \
util-macros \
vlan \
watchdog \
wget \
which \
wireless-tools \
wpa-supplicant \
yp-tools \
yp-tools-dev \
ypbind-mt \
zip \
zlib \
${LXC_SUPPORT} \
${@bb.utils.contains('DISTRO_FEATURES', 'simicsfs', \
		     'simicsfs-client fuse', '', d)} "

LXC_SUPPORT = "xz gnupg cgroup-lite libvirt libvirt-libvirtd \
	       lxc lxc-setup lxc-templates "

SDKIMAGE_FEATURES = "dev-pkgs dbg-pkgs staticdev-pkgs"
TOOLCHAIN_TARGET_TASK_append = " libc-staticdev"
