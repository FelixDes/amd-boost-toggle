libxcrypt-compat


# amd-boost-toggle

Linux turbo boost switch for AMD processors

# ⬇ Installation

## 📦 By package manager

TBD

## ⚙ Manually

Clone the repo, then run
```shell
./gradlew linkReleaseExecutableNative
```
After that you can take a binary from `build/bin/native/releaseExecutable`

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