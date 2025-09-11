import re
word = "my number is 123-456-789 and 0806983572"
pattern = r"\b\d{3}-\d{3}-\d{3}\b"
print(re.search(pattern,word).group())

email = "my brothers email is samuel222-chukwunonso360@gmail.com"
pattern = r"\b[\w-]+@[\w.]+\b"
print(re.findall(pattern,email))

text = "Alice And bob are Good Friends"
pattern = r"\b\w*[A-Z]+\w*\b"
word = re.findall(pattern,text)
print(word)
for words in word:
    print(len(words))


sentence = "Hello! How are you doing?"
pattern = r"\b\w+\b"
print(re.findall(pattern,sentence))