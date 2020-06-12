
# TODO get version from somewhere?
newVersion="1.8"
sed -i .bak "s|<version>.*</version>|<version>$newVersion</version>|" README.md
sed -i .bak "s|'com.solubris:typedtuples:.*'|'com.solubris:typedtuples:$newVersion'|" README.md

