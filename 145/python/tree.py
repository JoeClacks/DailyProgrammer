s = input('-->')

width, trunk, leafs = s.split(' ')

width = int(width)

currentWidth = 1
while currentWidth <= width:
	spacing = int(width / 2 - currentWidth / 2);

	print((' ' * spacing) + (leafs * currentWidth))

	currentWidth += 2

spacing = int(width / 2 - 1)

print((' ' * spacing) + (trunk * 3))
	
