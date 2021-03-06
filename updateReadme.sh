# Copyright $today.year Solubris Ltd.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# XXX project.version from the pom is the next version, but need the current version
#newVersion=${1?"new version is required"}
#newVersion=${newVersion%%-SNAPSHOT}

newVersion=$(sed -n '/project.rel/s/.*=//p' release.properties)

echo Patching README.md with version $newVersion
# TODO get version from somewhere?
sed -i .bak "s|<version>.*</version>|<version>$newVersion</version>|" README.md
sed -i .bak "s|'com.solubris:typedtuples:.*'|'com.solubris:typedtuples:$newVersion'|" README.md

git commit --verbose -m "Bump version in README.md to $newVersion" README.md
