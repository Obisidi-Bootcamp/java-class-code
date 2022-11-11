package com.bptn.service;

import com.bptn.exceptions.InvalidHistoryException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.models.History;
import com.bptn.repository.FeedHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class FeedHistoryService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FeedHistoryRepository feedHistoryRepository;
    @Autowired
    private UserService userService;
    public List<History> getPostsByUsername(String username) throws InvalidUserNameException {
        LOGGER.info("retrieving History from DB by username");
        userService.validateUserId(username);
        List<History> history = feedHistoryRepository.findByUsername(username);
        history = removeEmptyHistory(history);
        LOGGER.debug("Feeds History={}", history);
        return history;
    }
    public History getPostsByPostId(String postID) throws InvalidHistoryException {
        LOGGER.info("retrieving History from DB by postId");
        History history = feedHistoryRepository.findByPostId(postID);
        if (history == null) {
            throw new InvalidHistoryException("history data  doesn't exist");
        }
        LOGGER.debug("Feed history={}", history);
        return history;
    }
    public List<History> getPostsByPostType(String postType) throws InvalidHistoryException {
        LOGGER.info("retrieving History from DB by postType");
        List<History> history = feedHistoryRepository.findByPostType(postType);
        if (history == null) {
            throw new InvalidHistoryException("History doesn't exist");
        }
        LOGGER.debug("Feed={}", history);
        return history;
    }
    public void deleteHistoryByPostType(String postType) throws InvalidHistoryException{
        try {

            feedHistoryRepository.deleteByPostType(postType);
            LOGGER.info("Deleted History from DB by postType");
        }
        catch(Exception e){
            throw new InvalidHistoryException("History does'nt exist");
        }
    }
    private List<History> removeEmptyHistory(List<History> history) {
        List<History> resultHistory = new LinkedList<>();
        for (History historyData : history) {
            if (historyData.getPostId() != null && !historyData.getPostId().isEmpty()) {
                resultHistory.add(historyData);
            }
        }
        return resultHistory;
    }
}
