import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private static final int TILE_SIZE = 25;
    private static final int GRID_WIDTH = 24;
    private static final int GRID_HEIGHT = 24;
    private static final int PANEL_WIDTH = GRID_WIDTH * TILE_SIZE;
    private static final int PANEL_HEIGHT = GRID_HEIGHT * TILE_SIZE;
    private static final int INITIAL_DELAY = 120;

    private final LinkedList<Point> snake = new LinkedList<>();
    private final Random random = new Random();
    private final Timer timer = new Timer(INITIAL_DELAY, this);

    private Point food;
    private Direction direction = Direction.RIGHT;
    private Direction nextDirection = Direction.RIGHT;
    private boolean running = true;
    private int score = 0;

    public SnakeGame() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(new GameKeyListener());
        startGame();
    }

    private void startGame() {
        snake.clear();
        snake.add(new Point(6, 12));
        snake.add(new Point(5, 12));
        snake.add(new Point(4, 12));
        direction = Direction.RIGHT;
        nextDirection = Direction.RIGHT;
        score = 0;
        running = true;
        spawnFood();
        timer.start();
    }

    private void spawnFood() {
        Point point;
        do {
            point = new Point(random.nextInt(GRID_WIDTH), random.nextInt(GRID_HEIGHT));
        } while (snake.contains(point));
        food = point;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawFood(g);
        drawSnake(g);
        drawScore(g);

        if (!running) {
            drawGameOver(g);
        }
    }

    private void drawGrid(Graphics g) {
        g.setColor(new Color(225, 225, 225));
        for (int x = 0; x <= PANEL_WIDTH; x += TILE_SIZE) {
            g.drawLine(x, 0, x, PANEL_HEIGHT);
        }
        for (int y = 0; y <= PANEL_HEIGHT; y += TILE_SIZE) {
            g.drawLine(0, y, PANEL_WIDTH, y);
        }
    }

    private void drawFood(Graphics g) {
        g.setColor(new Color(220, 70, 70));
        g.fillOval(food.x * TILE_SIZE + 3, food.y * TILE_SIZE + 3, TILE_SIZE - 6, TILE_SIZE - 6);
    }

    private void drawSnake(Graphics g) {
        for (int i = 0; i < snake.size(); i++) {
            Point part = snake.get(i);
            if (i == 0) {
                g.setColor(new Color(80, 220, 120));
            } else {
                g.setColor(new Color(50, 180, 90));
            }
            g.fillRoundRect(part.x * TILE_SIZE + 1, part.y * TILE_SIZE + 1, TILE_SIZE - 2, TILE_SIZE - 2, 8, 8);
        }
    }

    private void drawScore(Graphics g) {
        g.setColor(new Color(40, 40, 40));
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString("Score: " + score, 15, 28);
    }

    private void drawGameOver(Graphics g) {
        g.setColor(new Color(0, 0, 0, 170));
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.BOLD, 34));
        g.drawString("Game Over", PANEL_WIDTH / 2 - 105, PANEL_HEIGHT / 2 - 10);

        g.setFont(new Font("SansSerif", Font.PLAIN, 20));
        g.drawString("Press SPACE to restart", PANEL_WIDTH / 2 - 110, PANEL_HEIGHT / 2 + 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollision();
        }
        repaint();
    }

    private void move() {
        direction = nextDirection;
        Point head = snake.getFirst();
        Point newHead = new Point(head);

        switch (direction) {
            case UP -> newHead.y--;
            case DOWN -> newHead.y++;
            case LEFT -> newHead.x--;
            case RIGHT -> newHead.x++;
        }

        snake.addFirst(newHead);

        if (newHead.equals(food)) {
            score++;
            spawnFood();
        } else {
            snake.removeLast();
        }
    }

    private void checkCollision() {
        Point head = snake.getFirst();

        if (head.x < 0 || head.x >= GRID_WIDTH || head.y < 0 || head.y >= GRID_HEIGHT) {
            running = false;
            timer.stop();
            return;
        }

        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                running = false;
                timer.stop();
                return;
            }
        }
    }

    private class GameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (!running && keyCode == KeyEvent.VK_SPACE) {
                startGame();
                repaint();
                return;
            }

            switch (keyCode) {
                case KeyEvent.VK_UP, KeyEvent.VK_W -> {
                    if (direction != Direction.DOWN) {
                        nextDirection = Direction.UP;
                    }
                }
                case KeyEvent.VK_DOWN, KeyEvent.VK_S -> {
                    if (direction != Direction.UP) {
                        nextDirection = Direction.DOWN;
                    }
                }
                case KeyEvent.VK_LEFT, KeyEvent.VK_A -> {
                    if (direction != Direction.RIGHT) {
                        nextDirection = Direction.LEFT;
                    }
                }
                case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> {
                    if (direction != Direction.LEFT) {
                        nextDirection = Direction.RIGHT;
                    }
                }
                default -> {
                }
            }
        }
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new SnakeGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
