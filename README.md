











| 기능         | url                                        | httpmethod | request                                                     | response                                                                                        | HttpStatus |
|--------------|--------------------------------------------|------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------------|------------|
| 일정추가하기 | /calendar                                  | ```post```       | { "name":"String",  "password":"String",  "text":"String" } | { "name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String" }     | ```201```        |
| 전체일정조회 |   "/{name}" ,  "/{name}/{day}" ,  "/{day}" | ```get```        | 없음                                                        | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"} ..... | ```200```        |
| 일정조회     | /{id}                                      | ```get```        | 없음                                                        | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"}       | ```200```        |
| 일정수정     | /{id}                                      | ```path```       | { "name":String "password":"String" "text":"String" }       | {"name":"String",  "text":"String", "CreationDate":"String", "ModificationDate":"String"}       | ```200```        |
| 삭제         | /{id}                                      | ```delect```     | 없음                                                        | 없음                                                                                            | ```204```        |
