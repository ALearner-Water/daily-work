# daily-work

按日期记录的小项目仓库。

## 项目列表

### 2026-04-18 Snake Game

- 路径：`2026-04-18-snake-game/`
- 语言：Java
- 类型：Swing 桌面小游戏
- 入口文件：`2026-04-18-snake-game/src/SnakeGame.java`

#### 运行方式

方式 1：双击运行

在项目目录中直接运行：

`2026-04-18-snake-game/run.bat`

方式 2：PowerShell 手动运行

```powershell
cd .\2026-04-18-snake-game
if (!(Test-Path .\out)) { New-Item -ItemType Directory -Path .\out | Out-Null }
javac -encoding UTF-8 -d out src\SnakeGame.java
java -cp out SnakeGame
```

#### 操作说明

- 方向键或 `WASD` 控制移动
- 游戏失败后按空格重新开始

## 说明

这个仓库目前保持“按日期 + 项目名”的记录方式，方便持续追加每天的小练习和独立项目。
