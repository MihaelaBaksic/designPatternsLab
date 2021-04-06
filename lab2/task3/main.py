
def mymax(iterable_, key_=None):
    max_x = None

    if key_ is None:
        key_ = lambda element: element

    for x in iterable_:
        if max_x is None or key_(x) > max_key:
            max_x = x
            max_key = key_(x)

    return max_x


if __name__ == '__main__':
    key = lambda x: len(x)

    array = ['aaaa', 'bs', 'bw', 'sss', 'eeeee', '']
    array_empty = []

    print('Max of {} is {}'.format(array, mymax(array, key)))
    print('Max of {} is {}'.format(array, mymax(array)))

    d = {'burek': '8', 'buhtla': '5'}
    print('Max of {} is {}'.format(d, mymax(d, lambda x: d.get(x))))

    fod = [('Frodo', 'Baggins'), ('Gandalf', 'The Gray'), ('Aragorn', 'Elessar'), ('Legolas', 'Greenleaf')]
    print('Max of {} is {}'.format(fod, mymax(fod, lambda x: (x[1], x[0]))))
