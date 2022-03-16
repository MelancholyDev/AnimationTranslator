from gtts import gTTS
import sys
sourceFile = sys.argv[1]
destanationFile = sys.argv[2]
sourceLanguage = sys.argv[3]
f = open(sourceFile, 'r',encoding="utf-8")
contents = f.read()
v = gTTS(text = contents,lang=sourceLanguage)
v.save(destanationFile)

