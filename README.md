# FileCopier
## 매우 귀찮은 작업
우리는 다음과 같은 작업을 해야할 때가 있습니다.
`foo/1/bar/baz.txt, foo/2/bar/baz.txt, foo/3/bar/baz.txt, foo/5/bar/baz.txt`
를
`foo/1/bar2/baz.txt, foo/2/bar2/baz.txt, foo/3/bar2/baz.txt, foo/5/bar/baz.txt`
로 복사!

이는 매우 귀찮은 작업이 아닐 수 없습니다.

## 귀찮으면 만들어 쓰자
귀찮으면 만들어 쓰면 됩니다.
이 프로그램에 필요한 파라미터는 다음과 같습니다.

1. `Parent Prefix`
위의 예에서 foo와 같습니다.
2. `Regex`
위의 예에서 1,2,3,5등과 같습니다.
이는 정규표현식으로 입력합니다. 꼭 하위에 bar/baz.txt가 있는 디렉터리의 이름으만 특징지을 필요는 없습니다.
하위에 bar/baz.txt가 없거나, 해당 이름의 디렉터리 자체가 존재하지 않아도 알아서 하위에 bar/baz.txt가 있는, 존재하는 디렉터리만 스캔합니다.
그러므로 그냥 예시의 경우엔 [0-9]로 입력해도 상관이 없습니다.
3. `Parent Postfix`
위의 예시에서 bar와 같습니다.
4. `Target Postfix`
위의 예시에서 bar2와 같습니다.
5. `Filename`
위의 예시에서 baz.txt와 같습니다.

## 작동
간단히 Copy버튼을 누르세요! 작업이 완료되지 않으면 예외메시지가 나오고, 작업이 완료된다면 log파일이 남습니다.

log파일에는 처리가 완료된 regexPart들이 기록됩니다.

위의 예시에서 생성된 로그파일은
```
1
2
3
5
```
와 같습니다.