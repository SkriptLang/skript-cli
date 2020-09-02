# skript-cli

![GitHub Workflow Status](https://img.shields.io/github/workflow/status/SkriptLang/skript-cli/build_cli?style=for-the-badge) ![GitHub License](https://img.shields.io/github/license/SkriptLang/skript-cli?style=for-the-badge)

## Install

**Ubuntu (and I guess MacOS)**

Open your terminal and run ``chmod +x path/to/the/downloaded/cli/file``.

**Windows:**

Follow the steps [on this site](https://docs.telerik.com/teststudio/features/test-runners/add-path-environment-variables) to add the ``path/to/the/downloaded/cli/file.exe`` and make it executable.

***To note:** You can rename the file to have a better executable. If you want to have a command like "sk" instead of "skript-cli", simply rename the file "sk" and add it to paths. The name will never change when updating skript-cli.*

## Usage

**Current existing commands:**

```
sk - Go in the playground of Skript
sk help - Show an help message about cli
sk run <script path> - Run a script
sk update - Update the CLI with latest available version. Fail if the OS is not supported.
```

More commands can come later. Don't hesitate to suggest us some commands by [creating an issue](https://github.com/SkriptLang/skript-cli/issues)

## Building

When you clone the **skript-cli**'s project, you need to download the submodule. You can either execute ``git clone https://github.com/SkriptLang/skript-cli.git --recurse-submodules --remote-submodules`` to clone correctly the project, either:

```
git clone https://github.com/SkriptLang/skript-cli.git
git submodule update --init --recursive --remote 
```

To build the project to simple jar files, you have simply to run ``gradle build``. All compiled files will be available in the directory ``build/libs`` at the root of the project.

If you want to build the CLI as native executable, run ``gradle nativeImage``. The CLI will be available at ``build/graal/skript.exe``.

*If you are a **Windows** user, you need to set up Visual C Build Tools Workload for Visual Studio 2017 Build Tools if you want to build the CLI as native executable. You can install it easily using [chocolatey](chocolatey.org/): ``choco install visualstudio2017-workload-vctools``*
*After that, you simply need to run it before build: ``call "C:\Program Files (x86)\Microsoft Visual Studio\2017\BuildTools\VC\Auxiliary\Build\vcvars64.bat"``*

## License

Code released under MIT license.

Copyright ©, [SkriptLang](https://github.com/SkriptLang).