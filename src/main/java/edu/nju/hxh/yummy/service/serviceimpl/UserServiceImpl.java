package edu.nju.hxh.yummy.service.serviceimpl;

import edu.nju.hxh.yummy.entity.User;
import edu.nju.hxh.yummy.repository.UserRepository;
import edu.nju.hxh.yummy.service.UserService;
import edu.nju.hxh.yummy.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author hxh
 * @date 2019-02-17 09:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResultMessage signUp(User user) {
        Optional<User> opt = userRepository.findAllByEmail(user.getEmail());
        if (opt.isPresent()) {
            if (opt.get().getState() == User.State.CANCELED) {
                return ResultMessage.CANCELED;
            } else {
                return ResultMessage.EXISTED;
            }
        } else {
            userRepository.save(user);
            return ResultMessage.SUCCESS;
        }
    }

    @Override
    public ResultMessage logIn(User user) {
        Optional<User> userOpt = userRepository.findAllByEmail(user.getEmail());
        if (userOpt.isPresent()) {
            if (userOpt.get().getEmail().equals(user.getEmail()) && userOpt.get().getPassword().equals(user.getPassword())) {
                return ResultMessage.SUCCESS;
            }
        }
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage activate(String token) {
        User user = userRepository.findByToken(token).orElse(null);
        if (user != null) {
            if (user.getState() == User.State.UNAUTHORIZED) {
                user.setState(User.State.NORMAL);
                userRepository.save(user);
                return ResultMessage.SUCCESS;
            }
        }
        return ResultMessage.FAILED;
    }
}
