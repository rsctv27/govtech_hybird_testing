# Govtech Hybird Testing

## Installation On MacOs

### First we need to install Java.

Use the package manager [brew](https://brew.sh/) to install java on MacOs.

1. Install brew.
```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```
2. Update brew and install homebrew cask.
```bash
brew update
brew tap homebrew/cask-versions
brew update
brew tap caskroom/cask
```
3. Install java.
```bash
brew install --cask adoptopenjdk@11
```
4. Set JAVA_HOME after installation.

add or edit file .zshrc
```bash
vim .zshrc

export PATH=$PATH:$HOME/bin
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME:$PATH
```

reload file .zshrc

```bash
source ~/.zshrc
```

5. Check java version.
```bash
java --version
```

### Second we need to install Gradle.

1. Install gradle
```bash
brew install gradle.
```

2. Check gradle version.
```bash
gradle --version
```

## Installation On Linux
### First we need to install Java.

Use the package manager apt to install java on Linux.

1. Update package.
```bash
sudo apt update
```
2. Update brew.
```bash
brew update
```
3. Install java.
```bash
sudo apt install default-jre
java -version

sudo apt install default-jdk
javac -version
```
4. Set JAVA_HOME after installation.


check java path installation
```bash
sudo update-alternatives --config java
```

add or edit file /etc/environment
```bash
sudo nano /etc/environment
JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"
```
reload file  /etc/environment
```bash
source /etc/environment
```
5. Check java version.
```bash
java --version
```

### Second we need to install Gradle.

1. Install gradle.
```bash
VERSION=7.0

wget https://services.gradle.org/distributions/gradle-${VERSION}-bin.zip -P /tmp

sudo unzip -d /opt/gradle /tmp/gradle-${VERSION}-bin.zip
sudo ln -s /opt/gradle/gradle-${VERSION} /opt/gradle/latest

```
2. Set GRADLE_HOME after installation.
```bash
sudo nano /etc/profile.d/gradle.sh
export GRADLE_HOME=/opt/gradle/latest
export PATH=${GRADLE_HOME}/bin:${PATH}

sudo chmod +x /etc/profile.d/gradle.sh

source /etc/profile.d/gradle.sh
```


3. Check gradle version.
```bash
gradle -v
```


## Run Project

###  Web Testing
1. clone the project

2. set env.properties
```bash
browser=chrome
host=https://www.saucedemo.com/
browser_version=88.0.4324.27
```

3. run project with all feature/scenario
```bash
gradle cucumber_web
```

4. run project with feature/scenario with spesific tag
```bash
gradle cucumber_web -P tags=@test-web

example:
run scenario 1
gradle cucumber_web -P tags=@scenario-web-1
```

###  Api Testing
1. run project with all feature/scenario
```bash
gradle cucumber_api
```

2. run project with feature/scenario with spesific tag
```bash
gradle cucumber_api -P tags=@test-api

example:
run scenario 1
gradle cucumber_api -P tags=@scenario-api-1

```

