# 2026-04-18 Snake Game

第一次借助 Codex 完成的一个 Java Swing 小项目，实现了一个可直接运行的桌面贪吃蛇游戏。

## 项目简介

- 语言：`Java 17`
- 类型：`Swing 桌面小游戏`
- 入口文件：`src/main/java/SnakeGame.java`
- 启动脚本：`run.bat`

## 目录说明

```text
2026-04-18-snake-game/
├─ src/
│  └─ main/
│     └─ java/
│        └─ SnakeGame.java
├─ out/
├─ pom.xml
├─ run.bat
└─ README.md
```

说明：

- `src/main/java/` 存放源码
- `run.bat` 用于一键编译并运行
- `out/` 为本地编译输出目录，可按需清理

## 运行方式

### 方式 1：直接运行脚本

双击：

```bat
run.bat
```

### 方式 2：在 PowerShell 中运行

在当前项目目录执行：

```powershell
if (!(Test-Path .\out)) { New-Item -ItemType Directory -Path .\out | Out-Null }
javac -encoding UTF-8 -d out src\main\java\SnakeGame.java
java -cp out SnakeGame
```

### 方式 3：使用 IntelliJ IDEA

1. 打开 IntelliJ IDEA
2. 选择 `Open`
3. 打开当前项目文件夹 `2026-04-18-snake-game`
4. 等待 IDEA 识别 `pom.xml`
5. 打开 `src/main/java/SnakeGame.java`
6. 运行 `main` 方法

如果无法运行，检查：

- 已正确配置 JDK
- 语言级别为 `17` 或更高

## 操作说明

- 方向键或 `WASD` 控制移动
- 游戏失败后按空格键重新开始
