SnakeGame 运行说明

方式 1：
双击 run.bat

方式 2：
在当前文件夹打开 PowerShell 后执行：

if (!(Test-Path .\out)) { New-Item -ItemType Directory -Path .\out | Out-Null }
javac -encoding UTF-8 -d out src\SnakeGame.java
java -cp out SnakeGame

IDEA 打开方式：
1. 打开 IntelliJ IDEA
2. 选择 Open
3. 选择整个 SnakeGame 文件夹
4. 等待 IDEA 识别 pom.xml
5. 打开 src\SnakeGame.java
6. 点击 main 方法左边的绿色三角运行

如果还是不能运行：
1. 打开 File -> Project Structure
2. 把 Project SDK 设置成已安装的 JDK
3. 把 Language level 设成 17 或更高

操作：
- 方向键或 WASD 控制移动
- 空格键在失败后重新开始
