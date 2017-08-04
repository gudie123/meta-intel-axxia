require recipes-core/images/core-image-minimal-dev.bb

IMAGE_INSTALL = " \
acl \
at \
attr \
autofs \
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
busybox-syslog \
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
diffutils \
dmidecode \
e2fsprogs \
e2fsprogs-badblocks \
e2fsprogs-e2fsck \
e2fsprogs-mke2fs \
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
libubsan \
libcap \
libcheck \
libdaemon \
libevent \
libffi \
libgcrypt \
libgpg-error \
libice \
libkmod \
libnfsidmap \
libnl \
libnss-mdns \
libogg \
libpython2 \
libpam \
libpcap \
libpcap-dev \
libpcre \
libsamplerate0 \
libsm \
libsndfile1 \
libtasn1 \
libtirpc \
libtool \
libudev \
libusb1 \
libusb-compat \
libxau \
libxcb \
libxdmcp \
logrotate \
lrzsz \
ltp \
lttng-modules \
lttng-modules-dev \
lttng-tools \
lttng-tools-dev \
lttng-ust \
lttng-ust-dev \
lzo \
man \
man-pages \
mdadm \
mktemp \
modutils-initscripts \
msmtp \
mtd-utils \
ncurses \
netbase \
net-tools \
nfs-utils \
nfs-utils-client \
openssh \
openssh-sftp \
openssl \
opkg \
opkg-arch-config \
ossp-uuid \
packagegroup-core-boot \
packagegroup-core-buildessential \
parted \
pciutils \
perf \
perl \
perl-module-bigint \
pkgconfig \
popt \
portmap \
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
sudo \
sysfsutils \
sysklogd \
tar \
tcl \
tcpdump \
tcp-wrappers \
time \
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
ypbind-mt \
yp-tools \
yp-tools-dev \
zip \
zlib \
${@base_conditional('MACHINE', 'axxiax86-64', 'axxia-rc-local', '', d)} \
${LXC_SUPPORT} "

LXC_SUPPORT = "xz gnupg cgroup-lite libvirt libvirt-libvirtd \
	       lxc lxc-setup lxc-templates lxc-networking "

DESCRIPTION = ""

SDKIMAGE_FEATURES = "dev-pkgs dbg-pkgs staticdev-pkgs"
TOOLCHAIN_TARGET_TASK_append = " libc-staticdev"
