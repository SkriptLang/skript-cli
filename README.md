# skript-cli

![GitHub Workflow Status](https://img.shields.io/github/workflow/status/SkriptLang/skript-cli/build_cli?style=for-the-badge) ![GitHub License](https://img.shields.io/github/license/SkriptLang/skript-cli?style=for-the-badge)

## Install

**WARNING:** You need Java installed on your computer to make this work. Without it, nothing will work!

### Ubuntu (and I guess MacOS)

Open your terminal and run

```shell
$ cd path/to/the/downloaded/cli/file
$ sudo [ -d "/etc/profile.d/" ] && echo "alias skript='. $PWD/binairies/skript.sh'" | sudo tee -a /etc/profile.d/skript-aliases.sh || echo "Can't create Skript's alias: directory /etc/profile.d/ seems to not exist"
```

In one line:

```shell
$ sudo sh -c 'cd path/to/the/downloaded/cli/file' && [ -d "/etc/profile.d/" ] && echo "alias skript='. $PWD/binairies/skript.sh'" | sudo tee -a /etc/profile.d/skript-aliases.sh || echo "Can't create Skript's alias: directory /etc/profile.d/ seems to not exist"
```

*This command simply go to the downloaded project and add a terminal alias (requires ``sudo`` user)*

### Windows: 

Follow the steps [on this site](https://docs.telerik.com/teststudio/features/test-runners/add-path-environment-variables) to add the ``./binairies`` folder from the downloaded project to make it executable.

## Usage

### Current existing commands:

```
skript - Go in the playground of Skript
skript help - Show an help message about cli
skript run <script path> - Run a script
skript update - Update the CLI with latest available version. Fail if the OS is not supported.
```

More commands can come later. Don't hesitate to suggest us some commands by [creating a discussion](https://github.com/SkriptLang/skript-cli/discussions)

## Building

When you clone the **skript-cli**'s project, you need to download the submodule. You can either execute ``git clone https://github.com/SkriptLang/skript-cli.git --recurse-submodules --remote-submodules`` to clone correctly the project, either:

```
git clone https://github.com/SkriptLang/skript-cli.git
git submodule update --init --recursive --remote 
```

To build the project to simple jar files, you have simply to run ``gradle build``. All compiled files will be available in the directory ``build/libs`` at the root of the project.

To execute the compiled version, use ``./binairies/skript.bat your command`` on Windows, and ``./binairies/skript.sh your command`` on Linux or Mac

## License

Code released under MIT license.

Copyright ©, [SkriptLang](https://github.com/SkriptLang).