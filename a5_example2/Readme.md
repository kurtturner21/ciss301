# Example 5 code

Hitting the order button puts all the added JButton objects in a designed order. 

![order button results](order.png)

Then hitting the chaos button calls a function to randomly assigns the forground color, background color, x position and y position. 

![chaos button results](chaos.png)

### Example of the chaos button 

```java
	public void makeChaosOfButtons() {
		for(JButton tb : allButtons){
			int x = randomWithRange(20, 290);
			int y = randomWithRange(60, 400);
			int fr = randomWithRange(0, 255);
			int fg = randomWithRange(0, 255);
			int fb = randomWithRange(0, 255);
			int br = randomWithRange(0, 255);
			int bg = randomWithRange(0, 255);
			int bb = randomWithRange(0, 255);
			tb.setBackground(new Color(br, bg, bb));
			tb.setForeground(new Color(fr, fg, fb));
			tb.setLocation(x, y);
		}
	}
```
