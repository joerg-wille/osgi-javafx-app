#
# This script works around issue JDK-8165630
# JDK-8165630 Independent Background Images cannot be specified for Mac DMG and PKG bundlers
# https://bugs.openjdk.java.net/browse/JDK-8165630
#
# extracts background image for DMG and PKG from mosaic file
# mosaic file: cat "AEM Toolbox-background_dmg.png" "AEM Toolbox-background_pkg.png" > "AEM Toolbox-background.png"
#

BACKGROUND="AEM Toolbox-background.png"
BYTES_DMG_PNG=969
BYTES_PKG_PNG=2505
BUILD_MARKER=distribution.dist

mv "$BACKGROUND" mosaic

if [ -f "$BUILD_MARKER" ]
then
	echo "pkg build"
    dd if=mosaic of="$BACKGROUND" bs=$BYTES_DMG_PNG skip=1
else
	echo "dmg build"
    dd if=mosaic of="$BACKGROUND" bs=$BYTES_DMG_PNG count=1
fi

rm -f mosaic
