fruit_example = {
    "apple" : 10,
    "banana" : 5,
    "grapes" : 4,
    "kiwi" : 3
}
fruit_selection = input("what are you looking for:")
if(fruit_selection in fruit_example):
    print("yes, this is available:")
else:
    print("No, this is not available:")
