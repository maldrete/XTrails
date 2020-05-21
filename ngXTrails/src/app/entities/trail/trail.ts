import { Comment } from '../comment/comment';
import { Location } from '../location/location';

export class Trail {
  id: number;
  name: string;
  dogFriendly: boolean;
  hashtags: string;
  desciption: string;
  photos: string;
  rating: string;
  review: string;
  routeType: string;
  distance: string;
  elevationGain: number;
  articleLinks: string;
  directions: string;
  share: string;
  difficulty: string;
  weather: string;
  exercise: string;
  comment: Comment[];
  location: Location;


  constructor(
    id?: number,
    name?: string,
    dogFriendly?: boolean,
    hashtags?: string,
    desciption?: string,
    photos?: string,
    rating?: string,
    review?: string,
    routeType?: string,
    distance?: string,
    elevationGain?: number,
    articleLinks?: string,
    directions?: string,
    share?: string,
    difficulty?: string,
    weather?: string,
    exercise?: string,
    comment?: Comment[],
    location?: Location
  ) {
    this.id = id;
    this.name = name;
    this.dogFriendly = dogFriendly;
    this.hashtags = hashtags;
    this.desciption = desciption;
    this.photos = photos;
    this.rating = rating;
    this.review = review;
    this.routeType = routeType;
    this.distance = distance;
    this.elevationGain = elevationGain;
    this.articleLinks = articleLinks;
    this.directions = directions;
    this.share = share;
    this.difficulty = difficulty;
    this.weather = weather;
    this.exercise = exercise;
    this.comment = comment;
    this.location = location;
  }
}
