package com.helpnow.service.impl;

import com.helpnow.dto.ResponseDTO;
import com.helpnow.entity.*;
import com.helpnow.repository.*;
import com.helpnow.service.GameService;
import com.helpnow.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class GameServiceImpl implements GameService {

    @Autowired
    Game1Repository game1Repository;

    @Autowired
    Game2Repository game2Repository;

    @Autowired
    Game3Repository game3Repository;

    @Autowired
    Game4Repository game4Repository;

    @Autowired
    Game5Repository game5Repository;

    @Autowired
    Game6Repository game6Repository;

    @Autowired
    Game7Repository game7Repository;

    @Autowired
    Game8Repository game8Repository;

    @Autowired
    Game9Repository game9Repository;

    @Autowired
    Game10Repository game10Repository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @Override
    public ResponseDTO swipeInForGame(String userId, int gameCount, LocalDate localDateNow, boolean rev) {
        List<Object> objectList = new ArrayList<>();
        Game1Details g1 = new Game1Details();
        Game2Details g2 = new Game2Details();
        Game3Details g3 = new Game3Details();
        Game4Details g4 = new Game4Details();
        Game5Details g5 = new Game5Details();
        Game6Details g6 = new Game6Details();
        Game7Details g7 = new Game7Details();
        Game8Details g8 = new Game8Details();
        Game9Details g9 = new Game9Details();
        Game10Details g10 = new Game10Details();

        objectList.add(g1);
        objectList.add(g2);
        objectList.add(g3);
        objectList.add(g4);
        objectList.add(g5);
        objectList.add(g6);
        objectList.add(g7);
        objectList.add(g8);
        objectList.add(g9);
        objectList.add(g10);


        UserEntity userEntity = userRepository.findByUserDBId(userId);

        if (userEntity != null) {
            List<Integer> gamesList = gamesPlayedList(userEntity);

            if (gameCount == 10 && gamesList.get(0) == 0 && gamesList.get(9) == 0) {
                int result = checkValid(gamesList, gameCount, true);
                if (result == 1) {
                    Game10Details game10Details = new Game10Details();
                    if (LocalDate.now().getDayOfWeek().getValue() == 6 || LocalDate.now().getDayOfWeek().getValue() == 7) {
                        userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 20));
                    } else {
                        userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 10));
                    }
                    userRepository.save(userEntity);
                    game10Details.setUserEntity(userEntity);
                    game10Repository.save(game10Details);
                }
            } else if (gameCount == 10 && gamesList.get(0) == 1 && gamesList.get(9) == 1) {
                int result = checkValid(gamesList, gameCount, false);
                if (result == 1) {
                    Game10Details game10Details = new Game10Details();
                    if (LocalDate.now().getDayOfWeek().getValue() == 6 || LocalDate.now().getDayOfWeek().getValue() == 7) {
                        userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 20));
                    } else {
                        userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 10));
                    }
                    userRepository.save(userEntity);
                    game10Details.setUserEntity(userEntity);
                    game10Repository.save(game10Details);
                }
            }

            if (gameCount == 1 && gamesList.get(9) == 0 && gamesList.get(1) == 0) {
                int result = checkValid(gamesList, gameCount, false);
                if (result == 1) {
                    Game1Details game1Details = new Game1Details();
                    if (LocalDate.now().getDayOfWeek().getValue() == 6 || LocalDate.now().getDayOfWeek().getValue() == 7) {
                        userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 20));
                    } else {
                        userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 10));
                    }
                    userRepository.save(userEntity);
                    game1Details.setUserEntity(userEntity);
                    game1Repository.save(game1Details);
                }

            } else if (gameCount == 1 && gamesList.get(9) == 1 && gamesList.get(1) == 1) {
                int result = checkValid(gamesList, gameCount, true);
                if (result == 1) {
                    Game1Details game1Details = new Game1Details();
                    if (LocalDate.now().getDayOfWeek().getValue() == 6 || LocalDate.now().getDayOfWeek().getValue() == 7) {
                        userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 20));
                    } else {
                        userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 10));
                    }
                    userRepository.save(userEntity);
                    game1Details.setUserEntity(userEntity);
                    game1Repository.save(game1Details);
                }
            }

            if (gameCount != 10 && gameCount != 1) {
                if (gamesList.get(0) == 1) {
                    int result = checkValid(gamesList, gameCount, false);
                    if (result == 1) {
                        Object obj = gamesList.get(gameCount - 1);
                        if (LocalDate.now().getDayOfWeek().getValue() == 6 || LocalDate.now().getDayOfWeek().getValue() == 7) {
                            userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 20));
                        }
                        else {
                            userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 10));
                        }
                        userRepository.save(userEntity);
                    }
                } else if (gamesList.get(9) == 1) {
                    int result = checkValid(gamesList, gameCount, true);
                }
            }
        }

        return null;
    }

    public List<Integer> gamesPlayedList(UserEntity userEntity) {
        List<Integer> tempList = new ArrayList<>();

        if (game1Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game2Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game3Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game4Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game5Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game6Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game7Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game8Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game9Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        if (game10Repository.findByUserEntity(userEntity) != null) {
            tempList.add(1);
        } else {
            tempList.add(0);
        }
        return tempList;
    }

    public int checkValid(List<Integer> usersList, int gameCount, boolean rev) {
        if (!rev) {
            switch (gameCount) {

                case 2:
                    if (usersList.get(0) == 1) {
                        return 1;
                    } else {
                        return 0;
                    }

                case 3:
                    if (usersList.get(1) == 1) {
                        if (usersList.get(0) == 1) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 4:
                    if (usersList.get(2) == 1) {
                        if (usersList.get(1) == 1) {
                            if (usersList.get(0) == 1) {
                                return 1;
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 5:
                    if (usersList.get(3) == 1) {
                        if (usersList.get(2) == 1) {
                            if (usersList.get(1) == 1) {
                                if (usersList.get(0) == 1) {
                                    return 1;
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 6:
                    if (usersList.get(4) == 1) {
                        if (usersList.get(3) == 1) {
                            if (usersList.get(2) == 1) {
                                if (usersList.get(1) == 1) {
                                    if (usersList.get(0) == 1) {
                                        return 1;
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 7:
                    if (usersList.get(5) == 1) {
                        if (usersList.get(4) == 1) {
                            if (usersList.get(3) == 1) {
                                if (usersList.get(2) == 1) {
                                    if (usersList.get(1) == 1) {
                                        if (usersList.get(0) == 1) {
                                            return 1;
                                        } else {
                                            return 0;
                                        }
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 8:
                    if (usersList.get(6) == 1) {
                        if (usersList.get(5) == 1) {
                            if (usersList.get(5) == 1) {
                                if (usersList.get(4) == 1) {
                                    if (usersList.get(3) == 1) {
                                        if (usersList.get(2) == 1) {
                                            if (usersList.get(1) == 1) {
                                                if (usersList.get(0) == 1) {
                                                    return 1;
                                                } else {
                                                    return 0;
                                                }
                                            } else {
                                                return 0;
                                            }
                                        } else {
                                            return 0;
                                        }
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 9:
                    if (usersList.get(7) == 1) {
                        if (usersList.get(6) == 1) {
                            if (usersList.get(5) == 1) {
                                if (usersList.get(4) == 1) {
                                    if (usersList.get(3) == 1) {
                                        if (usersList.get(2) == 1) {
                                            if (usersList.get(1) == 1) {
                                                if (usersList.get(0) == 1) {
                                                    return 1;
                                                } else {
                                                    return 0;
                                                }
                                            } else {
                                                return 0;
                                            }
                                        } else {
                                            return 0;
                                        }
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 10:
                    if (usersList.get(8) == 1) {
                        if (usersList.get(7) == 1) {
                            if (usersList.get(6) == 1) {
                                if (usersList.get(5) == 1) {
                                    if (usersList.get(4) == 1) {
                                        if (usersList.get(3) == 1) {
                                            if (usersList.get(2) == 1) {
                                                if (usersList.get(1) == 1) {
                                                    if (usersList.get(0) == 1) {
                                                        return 1;
                                                    } else {
                                                        return 0;
                                                    }
                                                } else {
                                                    return 0;
                                                }
                                            } else {
                                                return 0;
                                            }
                                        } else {
                                            return 0;
                                        }
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                default:
                    return 0;
            }
        } else {
            switch (gameCount) {

                case 1:
                    if (usersList.get(9) == 1) {
                        if (usersList.get(8) == 1) {
                            if (usersList.get(7) == 1) {
                                if (usersList.get(6) == 1) {
                                    if (usersList.get(5) == 1) {
                                        if (usersList.get(4) == 1) {
                                            if (usersList.get(3) == 1) {
                                                if (usersList.get(2) == 1) {
                                                    if (usersList.get(1) == 1) {
                                                        return 1;
                                                    } else {
                                                        return 0;
                                                    }
                                                } else {
                                                    return 0;
                                                }
                                            } else {
                                                return 0;
                                            }
                                        } else {
                                            return 0;
                                        }
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 2:
                    if (usersList.get(9) == 1) {
                        if (usersList.get(8) == 1) {
                            if (usersList.get(7) == 1) {
                                if (usersList.get(6) == 1) {
                                    if (usersList.get(5) == 1) {
                                        if (usersList.get(4) == 1) {
                                            if (usersList.get(3) == 1) {
                                                if (usersList.get(2) == 1) {
                                                    return 1;
                                                } else {
                                                    return 0;
                                                }
                                            } else {
                                                return 0;
                                            }
                                        } else {
                                            return 0;
                                        }
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 3:
                    if (usersList.get(9) == 1) {
                        if (usersList.get(8) == 1) {
                            if (usersList.get(7) == 1) {
                                if (usersList.get(6) == 1) {
                                    if (usersList.get(5) == 1) {
                                        if (usersList.get(4) == 1) {
                                            if (usersList.get(3) == 1) {
                                                return 1;
                                            } else {
                                                return 0;
                                            }
                                        } else {
                                            return 0;
                                        }
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 4:
                    if (usersList.get(9) == 1) {
                        if (usersList.get(8) == 1) {
                            if (usersList.get(7) == 1) {
                                if (usersList.get(6) == 1) {
                                    if (usersList.get(5) == 1) {
                                        if (usersList.get(4) == 1) {
                                            return 1;
                                        } else {
                                            return 0;
                                        }
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 5:
                    if (usersList.get(9) == 1) {
                        if (usersList.get(8) == 1) {
                            if (usersList.get(7) == 1) {
                                if (usersList.get(6) == 1) {
                                    if (usersList.get(5) == 1) {
                                        return 1;
                                    } else {
                                        return 0;
                                    }
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 6:
                    if (usersList.get(9) == 1) {
                        if (usersList.get(8) == 1) {
                            if (usersList.get(7) == 1) {
                                if (usersList.get(6) == 1) {
                                    return 1;
                                } else {
                                    return 0;
                                }
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 7:
                    if (usersList.get(9) == 1) {
                        if (usersList.get(8) == 1) {
                            if (usersList.get(7) == 1) {
                                return 1;
                            } else {
                                return 0;
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 8:
                    if (usersList.get(9) == 1) {
                        if (usersList.get(8) == 1) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                case 9:
                    if (usersList.get(9) == 1) {
                        return 1;
                    } else {
                        return 0;
                    }

                default:
                    return 0;
            }
        }
    }
}


