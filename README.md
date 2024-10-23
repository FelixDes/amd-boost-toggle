# amd-boost-toggle

Linux turbo boost switch for AMD processors

# ⬇ Installation

## ⚙ Manually

Clone the repo and run

```shell
./gradlew linkReleaseExecutableNative
```

Then you can take binary file from [./build/bin/native/releaseExecutable](build/bin/native/releaseExecutable)

> Unobvious point - you need `libcrypt` to build-up. It can be installed as `libxcrypt-compat`

## 📦 By package manager

### AUR-based (Arch Linux, Manjaro Linux, EndeavourOS, Garuda Linux, etc)

```shell
yay -S amd-boost-toggle-bin
```

or

```shell
yay -S amd-boost-toggle-git
```

# 💻 Usage

```
$ amd-boost-toggle [<options>]

Options:
  -e, --enable
  -d, --disable
  -o, --out      return state
  -h, --help     Show this message and exit
```

# 👥 Contribution

If you want to improve the project follow the steps below:

1. Fork the repository
2. Create your branch from develop
3. Create merge request to develop branch.
4. Check that GitHub workflow completes

# ⚠ Attention ⚠

This app is designed primarily for gaming laptops with AMD CPUs to reduce micro-freezes in games.
However, it's not a perfect solution.
Disabling boost across all cores can significantly impact performance, as most games are optimized to utilize a single
CPU core.
A __better approach is to use__ a more fine-tuned tool like __[RyzenAdj](https://github.com/FlyGoat/RyzenAdj)__ for
managing CPU performance.  
But if you prefer a __quick solution without extra configuration__ and know the potential trade-offs, this tool could be
just what you need.