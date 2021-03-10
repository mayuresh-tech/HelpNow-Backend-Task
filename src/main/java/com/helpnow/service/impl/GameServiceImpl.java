package com.helpnow.service.impl;

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
    public int swipeInForGame(String userId, int gameCount, LocalDate localDateNow, boolean rev) {

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
                        if (LocalDate.now().getDayOfWeek().getValue() == 6 || LocalDate.now().getDayOfWeek().getValue() == 7) {
                            userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 20));
                        } else {
                            userEntity.getCardEntity().setCardBalance((userEntity.getCardEntity().getCardBalance() - 10));
                        }
                        userRepository.save(userEntity);
                        switch (gameCount) {
                            case 2:
                                Game2Details game2Details = new Game2Details();
                                game2Details.setUserEntity(userEntity);
                                game2Repository.save(game2Details);
                                break;

                            case 3:
                                Game3Details game3Details = new Game3Details();
                                game3Details.setUserEntity(userEntity);
                                game3Repository.save(game3Details);
                                break;

                            case 4:
                                Game4Details game4Details = new Game4Details();
                                game4Details.setUserEntity(userEntity);
                                game4Repository.save(game4Details);
                                break;

                            case 5:
                                Game5Details game5Details = new Game5Details();
                                game5Details.setUserEntity(userEntity);
                                game5Repository.save(game5Details);
                                break;

                            case 6:
                                Game6Details game6Details = new Game6Details();
                                game6Details.setUserEntity(userEntity);
                                game6Repository.save(game6Details);
                                break;

                            case 7:
                                Game7Details game7Details = new Game7Details();
                                game7Details.setUserEntity(userEntity);
                                game7Repository.save(game7Details);
                                break;

                            case 8:
                                Game8Details game8Details = new Game8Details();
                                game8Details.setUserEntity(userEntity);
                                game8Repository.save(game8Details);
                                break;

                            case 9:
                                Game9Details game9Details = new Game9Details();
                                game9Details.setUserEntity(userEntity);
                                game9Repository.save(game9Details);
                                break;

                            default:
                                return 0;
                        }
                    }
                } else if (gamesList.get(9) == 1) {
                    int result = checkValid(gamesList, gameCount, true);
                }
            }
        }
        return 0;
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


