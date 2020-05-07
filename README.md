# Comparing-Binary-Search-Trees-and-Arrays
This was a computer science data structures assignment where I had to compare the speed and efficiency of Binary Search Trees and traditional unsorted arrays

# Shai	Aarons	(ARNSHA011)

# Assignment	1:	Report	

**Part	1:	Object	Orientated	design	and	interaction	of	experiment**

The	Item	Class
This	is	the	class	that	is	used	to	store	the	
information	about	an	individual	object	of	the	
time	series	of	power	usage	for	a	suburban	
dwelling.	This	stores	information	such	as	the	
date	that	it	was	recorded,	the	global	active	
power	and	the	amount	of	voltage	used.	It	has	
both	accessor	and	mutator	methods	for	
receiving	and	changing	the	specific	
information	about	the	3	indicated	instance	
variables.	It	also	has	toString	method	(which	
would	be	used	by	other	classes	as	I	will	
indicate	below)	that	returns	the	date/time,	
power	and	voltage	of	a	specific	object	in	a	
neatly	organized	string.	

The	PowerArrayApp
This	is	an	application	that	reads	in a	CSV	file	
called	‘cleaned_data.csv’	and	uses	a	set	of	
scanners	to	carefully	extract	the	required	
information	from	the	file	to	store	into	‘Item’	
objects.	I	decided	to	use	an	array	of	objects	in	
this	class	in	order	to	ease	the	workload	
required	for	this	practical.	So	every	time	the	
scanner	reads	a	new	line	of	the	CSV	file,	a	
new	‘Item’	object	is	created	and	stored	into	
the	fixed	size	array	(500)	of	‘Item’	objects.	Stored	in	this	class	is	a	static	instance	
variable	called	opCount	which	is	used	to	measure	the amount	of	comparison	
operations	that	occurs	when	one	uses	the	printDateTime	method	to	search	for	a	
specific	date/time	(used	as	the	key)	in	the	array	of	‘Item’	objects.	The	
printDateTime	method	receives	a	String	argument	in	the	form	of	a	specific	
date/time that	the	user	is	looking	and	returns	a	string	with	the	information	
relating	to	that	specific	date/time	using	the	toString	method	defined	in	the	Item	
class.	The	printAllDateTimes	method	returns	a	string	output of	all	the	date/times	
stored	in	the array	of		‘Item’	objects.	Just	before	the	program	terminates	the	
opCount	instance	variable	is	stored	in	a	text	file	called	ArrayPerformance.txt

Use	of	generics	throughout and	giving	credit	where	it	is	due:
In	designing	the	OOP	structure	of	the	binary	search	tree	I	decided	to	use	generics	
throughout	so	that	I	could	use	these	classes	in	later	projects	that	may	require	me	
to	use	a	binary	search	tree	with	objects	that	are	not	‘Item’	objects.	Furthermore,	I	
have	adapted	the	code	for	the	binary	search	tree	from	both	the	slides	provided	by	UCTand	the	textbook called	‘Data Structures	and	 Problem	Solving	Using	Java’

The	BinaryTreeNode<dataType> class
This	class	stores	a	private	generic	data	type	that	will	hold	the	object	that	is	being	
stored	in	the	binary	search	tree.	It	also	stores	the	reference	variables	to	the	left	
and	right	sub-nodes	(which	are	given	package	access	privacy	modifier	status).	It	
has	a	parameterized	constructor	that	stores	the	necessary	information	in	the	
instance	variables.	It	has	accessor	and	mutator	methods	for	the	left	and	right	
sub-trees.	It	has	a	toString	method	that	returns	the	data	item	that	it	is	storing’s	
toString	(i.e.	it	returns	data.toString()).	In	the	case	of	this	project	the	data	
variable	will	hold	an	‘Item’	object	and	it	will	be	able	to	use	the	‘Item’	objects	
toString	method	that	returns	the	data	necessary	to	be	returned	as	defined	in	the	
powerBSTApp	which	will	be	shown	below.

BinarySearchTree<dataType>	class
This	class	serves	as	the	typical	binary	search	tree	class.	I will	only	be	highlighting	
the	methods	that	are	used	by	this	practical, as	there	are	other	methods	I	have	
added	for	fun.	It	has	a	private	instance	variable	of	type	
BinaryTreeNode<dataType>	that	stores	the	root	node	of	the	binary	search	tree	
data	structure. It	also	has	an	integer	instance	variable	called	opCount,	which	
stores	the	amount	of	comparison	operations	that	occurs	when	a	search	is	
invoked	from	the	PowerBSTApp.	It	has	a	constructor,	which	simply	sets	the	root	
node	to	null,	and	the	opCount	to	zero.	It has	a	very	important	method,	which is	
critical	in	the	output	of	this	practical	called	visit.	This	method	receives	a	node	in	
the	binary	search	tree	and	returns	a	substring	of	the	first	19	letters	of	the	
toString	of	the	node.	The	reason	that	I	used	a	substring	was	so	that	in	traversals	
of	the	tree,	only	the	date/time	is	displayed	– as	is	required	by	the	
printAllDateTimes	method	in	the	PowerBSTApp	and	for	comparison	operations	
used	in	searching	(so	that	it	is	in	the	form:	dd/mm/yyyy/hh/mm/ss).	The	insert	
method	is	typical	of	any	binary	search	tree	implementation	and	there	is	nothing	
noteworthy	here,	merely	just	inserts	an	item	into	the	binary	search	tree.	The	find	
method	here	receives	a	string	that	in	this	practical	will	be	a	specific	date/time	
that	is	being	searched	for.	It	also	uses	a	substring	of	the	first	19	letters	of	the	
node	(that	is	passed	as	an	argument	to	the	method)	to	compare	to	the	search	
term.	The	find	method	also	updates	the	opCount	instance	variable	every	time	a	
comparison	operation	is	completed.	The	Binary	search	tree	also	has	an	inOrder	
traversal,	which	visits	each	node	in	the	tree	in	a	sorted	manner.

PowerBSTApp
This	is	an	application	that	reads	in	a	CSV	file	called	‘cleaned_data.csv’	and	uses	a	
set	of	scanners	to	carefully	extract	the	required	information	from	the	file	to	store	
into	‘Item’	objects.	So	every	time	the	scanner	reads	a	new	line	of	the	CSV	file,	a	
new	‘Item’	object	is	created	and	inserted	into	the	binary	search	tree	that	is	
stored	as	an	instance	variable.	The	printDateTime	method	receives	a	String	
argument	in	the	form	of	a	specific	date/time	that	the	user	is	looking	and	returns	
a	string	with	the	information	relating	to	that	specific	date/time	using	the	
toString	method	defined	in	the	Item	class	by	using	the	find	method	in	the	
BinarySearchTree	class.	The	printAllDateTimes	method	returns	a	string	output	


of	all	the	date/times	stored	in	the	binary	search	tree of		‘Item’	objects	using	the	
inOrder	traversal	defined	in	the	BinarySearchTree	class. Just	before	the	program	
terminates	the	opCount	instance	variable	is	stored	in	a	text	file	called	
BSTPerformance.txt

**Part	2:	Goal	of	Experiment	and	Method	of	Execution**
The	Goal
The	goal	of	this	experiment	was	to	use	the	above	OOP	design	to	demonstrate	the	
speed	differences	when	performing	a	search	through	a	specified	amount	of	data	
between	a	binary	search	tree	and	a	traditional	array	implementation.	The	test	
shows	which	data	structure	may	be	more	efficient when	we	vary	the size	of	the	
dataset	(N).	

The	Execution
In	order	to	do	this	test	effectively and	efficiently	I	decided	to	use	a	python	script	
that	interacts	with	the	shell	terminal	of	a	system.	The	script	did	the	following:

- It	had	a	loop	that	iterated	500	times	so	that	
    each	record	will	be	created	to	make	a	new	
    subset	of	the	entire	data	provided	to	us	(i.e.	a	
    new	N)
       o For	each	of	these	iterations,	it	added	a	
          new	line	of	the	source	data	from	a	CSV	
          file	called	‘uncleaned_data.csv’	to	a	new	
          file	called	‘cleaned_data.csv’	by	using	a	
          shell	script
       o For	each	iteration	two	empty	arrays	are	
          created
       o Then	a	new	loop	is	started	that	iterates	
          through	every	line	in	the	
          ‘cleaned_data.csv’	file.	
            ! For	every	line	it	iterates	through,	
                a	search	is	performed	by	using	
                the	command	line	entry	as	
                defined	in	the	PowerArrayApp	
                and	PowerBSTApp.	
            ! The	output	from	these	programs	
                (in the	arrayPerformance.txt	and	
                BSTPerformance.txt)	is	then	
                added	to	the	empty	arrays
       o Once	the	program	has	iterated	through	
          each	line	the	best	case,	average	case	and	
          worst	case	for	both	the	array	
          implementation	and	the	binary	search	
          tree	implementation	is	found	and	stored	in	separate	text	files	
Once	all	the	data	had	been	recorded	in	the	6	different	text	files	I	used	the	python	
module	matplotlib	to	create	the	graphs	that	will	be	shown	in the PDF file.

