# amd-boost-toggle

Linux turboboost switch for AMD processors

# ⚠ Attention ⚠

This app is designed primarily for gaming laptops with AMD CPUs to reduce micro-freezes in games.
However, it's not a perfect solution.
Disabling boost across all cores can significantly impact performance, as most games are optimized to utilize a single
CPU core.
A __better approach is to use__ a more fine-tuned tool like __[RyzenAdj](https://github.com/FlyGoat/RyzenAdj)__ for
managing CPU performance.
But if you prefer a __quick solution without extra configuration__ and know the potential trade-offs, this tool could be
just what you need.

# ⬇ Installation

__TBD__

# 💻 Usage

```
$ turbo-boost-toggle [<options>]

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
